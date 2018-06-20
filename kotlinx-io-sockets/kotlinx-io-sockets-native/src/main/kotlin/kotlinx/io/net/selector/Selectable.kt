package kotlinx.io.net.selector

import platform.linux.EPOLLIN
import platform.linux.EPOLLOUT

/**
 * A selectable entity that could be processed by [SelectorManager].
 * One selectable could be associated only with one particular [SelectorManager].
 *
 * [SelectorManager] implementation MUST respect the following rule: one selectable could be added at most to one
 * local heap ([SelectablesHeap]) and at most one safe heap ([SafeSelectablesHeap]).
 */
actual abstract class Selectable {
    private var _readyOps: Int = 0
    private var _interestedOps: Int = 0

    internal actual val suspensions = InterestSuspensionsMap()

    internal actual var id: Int
        get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        set(value) {}

    internal actual var localHeapIndex: Int = -1
    internal actual var safeHeapIndex: Int = -1

    internal actual val readyOps: Int get() = _readyOps
    internal actual val interestedOps: Int get() = _interestedOps

    abstract val fd: Int

    internal actual fun addInterest(flag: Int): Boolean {
        val oldInterest = _interestedOps
        if (oldInterest and flag != 0) return false
        val newInterest = oldInterest or flag
        _interestedOps = newInterest
        return true
    }

    internal actual fun removeInterest(flag: Int): Boolean {
        val oldInterest = _interestedOps
        if (oldInterest and flag == 0) return false
        val newInterest = oldInterest and flag.inv()
        _interestedOps = newInterest
        return true
    }

    internal actual fun checkReady(flag: Int): Boolean {
        return _readyOps and flag != 0
    }

    actual open fun close() {
        _interestedOps = 0
        _readyOps = 0
    }
}

actual enum class SelectInterest(epollFlag: Int) {
    READ(EPOLLIN),
    WRITE(EPOLLOUT),
    ACCEPT(EPOLLIN),
    CONNECT(EPOLLOUT);

    internal actual val flag: Int = epollFlag

    actual companion object {
        actual val AllInterests: Array<SelectInterest> = values()
        internal actual val flags: IntArray = values().map { it.flag }.toIntArray()
        actual val size: Int = values().size
    }
}