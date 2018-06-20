package kotlinx.io.net.selector

import kotlin.coroutines.experimental.*

internal expect class InterestSuspensionsMap() {
    fun addSuspension(interest: SelectInterest, continuation: Continuation<Unit>)
    inline fun invokeForEachPresent(readyOps: Int, block: Continuation<Unit>.() -> Unit)
    inline fun invokeForEachPresent(block: Continuation<Unit>.(SelectInterest) -> Unit)

    fun removeSuspension(interest: SelectInterest): Continuation<Unit>?
    fun removeSuspension(interestOrdinal: Int): Continuation<Unit>?
}