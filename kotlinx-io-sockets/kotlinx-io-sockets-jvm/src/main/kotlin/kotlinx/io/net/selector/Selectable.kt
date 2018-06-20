package kotlinx.io.net.selector

import java.nio.channels.*
import java.util.concurrent.atomic.*

/**
 * A selectable entity that could be processed by [SelectorManager].
 * One selectable could be associated only with one particular [SelectorManager].
 *
 * [SelectorManager] implementation MUST respect the following rule: one selectable could be added at most to one
 * local heap ([SelectablesHeap]) and at most one safe heap ([SafeSelectablesHeap]).
 */
actual abstract class Selectable {
    internal actual val suspensions = InterestSuspensionsMap()

    @Volatile
    private var _readyOps: Int = 0

    @Volatile
    private var _interestedOps: Int = 0

    internal var key: SelectionKey? = null

    internal actual var id: Int
        get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        set(value) {}

    internal actual var localHeapIndex: Int = -1

    @Volatile
    internal actual var safeHeapIndex: Int = -1

    internal actual val readyOps: Int get() = _readyOps
    internal actual val interestedOps: Int get() = _interestedOps

    abstract val nioChannel: SelectableChannel

    internal actual fun addInterest(flag: Int): Boolean {
        while (true) {
            val oldInterest = _interestedOps
            if (oldInterest and flag != 0) return false
            val newInterest = oldInterest or flag
            if (InterestedOps.compareAndSet(this, oldInterest, newInterest)) return true
        }
    }

    internal actual fun removeInterest(flag: Int): Boolean {
        while (true) {
            val oldInterest = _interestedOps
            if (oldInterest and flag == 0) return false
            val newInterest = oldInterest and flag.inv()
            if (InterestedOps.compareAndSet(this, oldInterest, newInterest)) return true
        }
    }

    internal actual fun checkReady(flag: Int): Boolean {
        return _readyOps and flag != 0
    }

    actual open fun close() {
        _interestedOps = 0
        _readyOps = 0
    }

    companion object {
        val ReadyOps = AtomicIntegerFieldUpdater.newUpdater(Selectable::class.java, Selectable::_readyOps.name)!!
        val InterestedOps = AtomicIntegerFieldUpdater.newUpdater(Selectable::class.java, Selectable::_interestedOps.name)!!
    }
}

actual enum class SelectInterest(nioFlag: Int) {
    READ(SelectionKey.OP_READ),
    WRITE(SelectionKey.OP_WRITE),
    ACCEPT(SelectionKey.OP_ACCEPT),
    CONNECT(SelectionKey.OP_CONNECT);

    internal actual val flag: Int = nioFlag

    actual companion object {
        actual val AllInterests: Array<SelectInterest> = values()
        actual val size: Int = values().size

        @PublishedApi
        internal actual val flags: IntArray = values().map { it.flag }.toIntArray()
    }
}