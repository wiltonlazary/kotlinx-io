package kotlinx.io.net.selector

import java.nio.channels.*
import java.util.concurrent.atomic.*

internal class JavaSelectorManager : CommonSelectorManager() {
    private val selector: Selector = Selector.open()
    private var pendingCount = 0
    private var cancelled = 0
    private var wakeup = AtomicLong()

    @Volatile
    private var inSelect = false

    override fun poll(): Int {
        pendingCount += selector.selectNow()
        return pendingCount
    }

    override suspend fun waitFor(timeoutMillis: Long): Int {
        inSelect = true
        val rc = if (wakeup.get() == 0L) {
            val count = selector.select(500L)
            inSelect = false
            count
        } else {
            inSelect = false
            wakeup.set(0)
            selector.selectNow()
        }

        pendingCount += rc
        return pendingCount
    }

    override fun processSelected() {
        handleSelectedKeys(selector.selectedKeys())
    }

    override fun abortSelection() {
        if (inSelect) {
            selector.wakeup()
        }
    }

    override fun enqueueInterest(subject: Selectable) {
        val selector = selector
        val channel = subject.nioChannel

        try {
            val key = subject.key
            val ops = subject.interestedOps

            if (key == null) {
                if (ops != 0) {
                    subject.key = channel.register(selector, ops, subject)
                }
            } else {
                if (key.interestOps() != ops) {
                    key.interestOps(ops)
                }
            }
        } catch (t: Throwable) {
            channel.keyFor(selector)?.cancel()
            cancelAllSuspensions(subject, t)
        }
    }

    override fun applyEnqueuedInterests() {
    }

    override fun removeSelectable(subject: Selectable) {
        subject.key?.cancel()
        subject.key = null
        cancelled++
    }

    override fun close() {
        super.close()
        selector.close()
    }

    private fun handleSelectedKeys(selectedKeys: MutableSet<SelectionKey>) {
        val selectedCount = selectedKeys.size
        var cancelled = 0
        var pendingCount = 0

        if (selectedCount > 0) {
            val iter = selectedKeys.iterator()
            while (iter.hasNext()) {
                val k = iter.next()
                if (handleSelectedKey(k) != 0) {
                    pendingCount++
                } else if (!k.isValid) {
                    cancelled++
                }
            }

            selectedKeys.clear()
        }

        this.pendingCount = pendingCount
        this.cancelled = cancelled
    }

    /**
     * Process single selected [key]
     * @return new interest ops
     */
    private fun handleSelectedKey(key: SelectionKey): Int = try {
        val subj = key.subject
        if (subj == null) {
            key.cancel()
            0
        } else {
            val readyOps = key.readyOps()
            val interestOps = key.interestOps()

            val newOps = interestOps and readyOps.inv()
            if (newOps != interestOps) {
                key.interestOps(newOps)
            }

            processSelected(subj)

            newOps
        }
    } catch (t: Throwable) {
        // cancelled or rejected on resume?
        key.cancel()
        key.subject?.let { subj ->
            cancelAllSuspensions(subj, t)
            key.subject = null
        }
        0
    }
}

private inline var SelectionKey.subject: Selectable?
    get() = attachment() as? Selectable
    set(newValue) {
        attach(newValue)
    }
