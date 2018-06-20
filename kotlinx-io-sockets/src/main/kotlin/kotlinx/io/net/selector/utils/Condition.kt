package kotlinx.io.net.selector.utils

import kotlin.coroutines.experimental.*

internal interface Condition {
    fun check(): Boolean
    suspend fun await()
    suspend fun await(block: () -> Unit)
    fun signal(): Boolean
}

internal expect abstract class ConditionImpl<T>() : Condition {
    protected var continuation: Continuation<T>?
    protected fun removeContinuation(c: Continuation<T>): Boolean
}

internal fun condition(predicate: () -> Boolean): Condition = object : ConditionImpl<Unit>() {
    override fun check() = predicate()

    override suspend fun await() {
        if (predicate()) return

        return suspendCoroutine { c ->
            continuation = c
            if (predicate() && removeContinuation(c)) c.resume(Unit)
        }
    }

    override suspend fun await(block: () -> Unit) {
        if (predicate()) return

        return suspendCoroutine { c ->
            continuation = c
            if (predicate() && removeContinuation(c)) c.resume(Unit)
            block()
        }
    }

    override fun signal(): Boolean {
        val cont = continuation
        if (cont != null && predicate()) {
            if (removeContinuation(cont)) {
                cont.resume(Unit)
                return true
            }
        }

        return false
    }
}
