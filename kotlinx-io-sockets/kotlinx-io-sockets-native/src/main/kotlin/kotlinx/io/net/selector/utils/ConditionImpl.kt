package kotlinx.io.net.selector.utils

import kotlin.coroutines.experimental.*

internal actual abstract class ConditionImpl<T> actual constructor() : Condition {
    private var cond: Continuation<T>? = null

    protected actual var continuation: Continuation<T>?
        get() = cond
        set(value) {
            if (cond != null) {
                throw IllegalStateException("Await operation is already in progress")
            }
            cond = value
        }

    protected actual fun removeContinuation(c: Continuation<T>): Boolean {
        if (cond === c) {
            cond = null
            return true
        }

        return false
    }
}
