package kotlinx.io.net.selector

import kotlinx.io.net.selector.utils.*

private const val SELECTOR_BUFFER_SIZE = 8192

internal abstract class CommonSelectorManager : SelectorManager {
    private val messageBox = SafeSelectablesHeap(SELECTOR_BUFFER_SIZE)
    private val messageBoxAwait = condition { !messageBox.isEmpty }

    /**
     * Poll for new events from underlying selector
     * It generally shouldn't block however the underlying implementation may do mutex lock/unlock to guard internal
     * state so non-blocking behaviour is not guaranteed.
     *
     * @return number of selected entries or 0 if there are no events selected
     */
    protected abstract fun poll(): Int

    /**
     * Wait for new events from the underlying selector. Depending on the underlying implementations capabilities
     * it could suspend until events available or block (but at most [timeoutMillis])
     * Note that [timeoutMillis] is only applied to blocking mode while suspension time is not limited.
     *
     * @return number of selected entries
     */
    protected abstract suspend fun waitFor(timeoutMillis: Long): Int

    /**
     * Invoke [processSelected] for every selected subject previously selected via [poll] or [waitFor]
     */
    protected abstract fun processSelected()

    /**
     * Update [subject]'s interest. Depending on the underlying implementation it could apply interest immediately
     * or enqueue it until [applyEnqueuedInterests] invocation
     */
    protected abstract fun enqueueInterest(subject: Selectable)

    /**
     * Apply all enqueued interests. Depending on the underlying implementation it could process all enqueued interests
     * or do nothing if all interests were applied immediately or it will mark all enqueued entries to be
     * applied during the next [poll] or [waitFor] invocation.
     */
    protected abstract fun applyEnqueuedInterests()

    /**
     * Unregister [subject]: remove all interests
     */
    protected abstract fun removeSelectable(subject: Selectable)

    /**
     * Interrupt blocking [waitFor] operation
     */
    protected abstract fun abortSelection()

    /**
     * Selection loop coroutine
     */
    protected suspend fun loop() {
        val registered = SelectablesHeap(SELECTOR_BUFFER_SIZE)
        var doWait = false

        while (true) {
            val count = if (registered.isEmpty && messageBox.isEmpty) {
                messageBoxAwait.await()
                0
            } else if (doWait || messageBox.isEmpty) {
                waitFor(500)
            } else {
                poll()
            }

            if (count > 0) {
                processSelected()
            }

            val registeredCount = processMessageBox(registered)

            val waited = doWait
            doWait = count == 0 && registeredCount == 0

            if (waited && doWait) {
//                yield()
            }
        }
    }

    /**
     * Removes selectables from the message box and does setup underlying interests and add to [registered] heap.
     * @return number of selectables processed
     */
    private fun processMessageBox(registered: SelectablesHeap): Int {
        val mb = messageBox

        mb.poll()?.let {
            enqueueInterest(it)
            Unit
        } ?: return 0

        var registeredCount = 1
        while (true) {
            val fd = mb.poll() ?: break
            enqueueInterest(fd)
            registeredCount ++
        }

        applyEnqueuedInterests()

        return registeredCount
    }

    protected fun processSelected(s: Selectable): Boolean {
        // TODO process
        return s.interestedOps == 0
    }

    override fun notifyClosed(s: Selectable) {
        TODO()
    }

    override suspend fun select(selectable: Selectable, interest: SelectInterest) {
        val flag = interest.flag

        if (selectable.checkReady(flag)) return
        if (selectable.addInterest(flag)) {
            if (messageBox.add(selectable) && !messageBoxAwait.signal() && !messageBox.isEmpty) {
                // signal condition if selectable was added to mb (do nothing if it was already enqueued)
                // try to abort selection if message box is still not empty
                // and no suspension was resumed in messageBoxAwait
                abortSelection()
            }
        }

        // TODO await for selection
    }

    override fun close() {
        TODO()
    }

    /**
     * Cancel all subject's suspending coroutines
     */
    protected fun cancelAllSuspensions(subj: Selectable, t: Throwable) {
        TODO()
    }

    protected fun cancelAllSuspensions(t: Throwable) {
        TODO()
    }
}

internal expect class SafeSelectablesHeap(size: Int) {
    fun add(element: Selectable): Boolean
    fun poll(): Selectable?
    val isEmpty: Boolean
}

private class SelectablesHeap(size: Int) {
    private var elements = arrayOfNulls<Selectable?>(size)
    private var size = 0

    val isEmpty: Boolean get() = size == 0

    fun add(element: Selectable): Boolean {
        if (element.localHeapIndex != -1) return false

        if (size == elements.size) {
            grow()
        }

        val index = size
        size = index + 1

        elements[index] = element
        element.localHeapIndex = index

        return true
    }

    fun addAll(buffer: Array<Selectable?>, qty: Int) {
        if (size + qty > elements.size) {
            grow(size + qty)
        }

        var index = size
        val elements = elements

        for (i in 0 until qty) {
            val element = buffer[qty] ?: continue
            if (element.localHeapIndex != -1) continue

            elements[index] = element
            element.localHeapIndex = index

            index++
        }

        size = index
    }

    fun remove(element: Selectable): Boolean {
        val index = element.localHeapIndex
        if (index == -1) return false

        val size = size
        val elements = elements

        if (index >= size) throw IllegalArgumentException("Most likely the selectable is not from this heap")

        if (size == 1) {
            elements[0] = null
            this.size = 0
        } else {
            val lastIndex = size - 1
            elements[index] = elements[lastIndex]
            elements[lastIndex] = null
            this.size = lastIndex
        }

        element.localHeapIndex = -1

        return true
    }

    private fun grow() {
        elements = elements.copyOf(elements.size * 2)
    }

    private fun grow(atLeast: Int) {
        var newSize = elements.size

        while (newSize < atLeast) {
            newSize = newSize shl 1
        }

        elements = elements.copyOf(newSize)
    }
}

internal expect fun <T : Any> Array<T?>.zero(count: Int)
