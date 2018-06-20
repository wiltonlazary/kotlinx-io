package kotlinx.io.net.selector

import kotlinx.io.net.selector.utils.*
import kotlinx.cinterop.*
import platform.posix.*
import platform.linux.*

private const val EPOLL_ARRAY_SIZE = 8192
private const val MAX_EPOLL_TIMEOUT_MILLIS = 1800000L // 30 min

internal class EPollSelectorManager : CommonSelectorManager() {
    private val epollFd: Int
    private val epollArray: CArrayPointer<epoll_event>
    private val timespec: timespec
    private val epollSingleEvent: epoll_event
    private var selected = 0
    private val registered = SelectablesMap()

    init {
        val fd = epoll_create1(0)
        if (fd != -1) {
            throw SelectorException("Failed to create selector: epoll_create1() failed with ${posix_errno()}")
        }

        epollFd = fd

        epollArray = nativeHeap.allocArray<epoll_event>(EPOLL_ARRAY_SIZE)
        epollSingleEvent = nativeHeap.alloc<epoll_event>()
        timespec = nativeHeap.alloc<timespec>()
    }

    override fun poll(): Int {
        val before = selected
        if (before > EPOLL_ARRAY_SIZE) throw IllegalStateException("selected > MAX")
        val ptr = epollArray[before].ptr

        val remaininig = EPOLL_ARRAY_SIZE - before
        if (remaininig == 0) return before

        val rc = epoll_wait(epollFd, ptr, remaininig, 0)
        if (rc == -1) {
            throw SelectorException("Failed to poll events: ${posix_errno()}")
        }

        selected = before + rc
        return selected
    }

    override suspend fun waitFor(timeoutMillis: Long): Int {
        require(timeoutMillis >= 0L)

        val before = selected
        if (before > EPOLL_ARRAY_SIZE) throw IllegalStateException("selected > MAX")
        if (before > 0) return poll()

        val remaininig = EPOLL_ARRAY_SIZE - before
        if (remaininig == 0) return before

        if (timeoutMillis >= MAX_EPOLL_TIMEOUT_MILLIS && timeoutMillis != Long.MAX_VALUE) {
            // in Linux kernels older than 2.6.37
            // timeout larger than LONG_MAX / HZ could cause infinite sleep
            // due to integer overflow so we do workaround in this case
            return waitForLongDelay(timeoutMillis)
        }

        val ptr = epollArray[before].ptr
        val rc = epoll_wait(epollFd, ptr, remaininig, if (timeoutMillis == Long.MAX_VALUE) -1 else timeoutMillis.toInt())
        if (rc == -1) {
            throw SelectorException("Failed to poll events: ${posix_errno()}")
        }

        selected = before + rc
        return selected
    }

    override fun processSelected() {
        val selected = selected
        val epollArray = epollArray
        val registered = registered

        for (i in 0 until selected) {
            val e = epollArray[i]
            val events = e.events
            val fd = e.data.fd
            val selectable = registered[fd]

            if (selectable == null) {
                remove(fd, null)
            } else {
                if (processSelected(selectable)) {
                    remove(fd, selectable)
                }
            }
        }

        this.selected = 0
    }

    override fun abortSelection() {
        TODO()
    }

    override fun enqueueInterest(subject: Selectable) {
        val fd = subject.id
        try {
            val ops = subject.interestedOps

            val mod = if (ops == 0) {
                registered.remove(subject)
                EPOLL_CTL_DEL
            } else if (subject in registered) {
                EPOLL_CTL_MOD
            } else {
                registered.put(subject)
                EPOLL_CTL_ADD
            }

            epollSingleEvent.events = ops
            epollSingleEvent.data.fd = fd

            if (epoll_ctl(epollFd, mod, fd, epollSingleEvent.ptr) != 0) {
                throw SelectorException("Failed to amend subscription: epoll_ctl failed with ${posix_errno()}")
            }
        } catch (t: Throwable) {
            remove(fd, subject, t)
        }
    }

    override fun applyEnqueuedInterests() {
    }

    override fun removeSelectable(subject: Selectable) {
        remove(subject.id)
    }

    protected fun remove(fd: Int) {
        epoll_ctl(epollFd, EPOLL_CTL_DEL, fd, epollSingleEvent.ptr) // ignore errors
        registered.remove(fd)
    }

    private fun remove(fd: Int, selectable: Selectable?, t: Throwable? = null) {
        remove(fd)
        selectable?.let {
            cancelAllSuspensions(it, t ?: SelectorException("Selection cancelled"))
        }
    }

    override fun close() {
        super.close()
        nativeHeap.free(epollArray)
        nativeHeap.free(epollSingleEvent)
        nativeHeap.free(timespec)
    }

    private tailrec fun waitForLongDelay(timeoutMillis: Long): Int {
        val before = selected
        if (before > EPOLL_ARRAY_SIZE) throw IllegalStateException("selected > MAX")
        val ptr = epollArray[before].ptr
        val remaininig = EPOLL_ARRAY_SIZE - before
        if (remaininig == 0) return before

        val timeout = minOf(timeoutMillis, MAX_EPOLL_TIMEOUT_MILLIS).toInt()
        val start = currentTimeMillis()

        val rc = epoll_wait(epollFd, ptr, remaininig, timeout)
        if (rc == -1) {
            throw SelectorException("Failed to poll events: ${posix_errno()}")
        } else if (rc == 0) {
            val end = currentTimeMillis()
            val newTimeout = timeoutMillis - (end - start)
            if (newTimeout > 0L) {
                return waitForLongDelay(newTimeout)
            }
        }

        selected = before + rc
        return selected
    }

    private fun currentTimeMillis(): Long {
        clock_gettime(CLOCK_REALTIME, timespec.ptr)
        return timespec.tv_sec * 1000L + timespec.tv_nsec / 1_000_000L
    }
}

class SelectorException(message: String) : Exception(message)
