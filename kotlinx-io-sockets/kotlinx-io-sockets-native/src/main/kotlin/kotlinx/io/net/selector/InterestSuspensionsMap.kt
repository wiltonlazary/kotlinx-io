package kotlinx.io.net.selector

import kotlin.coroutines.experimental.*

internal actual class InterestSuspensionsMap {
    private val suspensions = arrayOfNulls<Continuation<Unit>>(SelectInterest.size)

    actual fun addSuspension(interest: SelectInterest, continuation: Continuation<Unit>) {
        if (suspensions[interest.ordinal] != null) {
            throw IllegalStateException("$interest is already in progress")
        }
        suspensions[interest.ordinal] = continuation
    }

    actual inline fun invokeForEachPresent(readyOps: Int, block: Continuation<Unit>.() -> Unit) {
        for (interest in SelectInterest.AllInterests) {
            if (interest.flag and readyOps != 0) {
                removeSuspension(interest.ordinal)?.let { cont -> block(cont) }
            }
        }
    }

    actual inline fun invokeForEachPresent(block: Continuation<Unit>.(SelectInterest) -> Unit) {
        for (interest in SelectInterest.AllInterests) {
            removeSuspension(interest.ordinal)?.let { cont -> block(cont, interest) }
        }
    }

    actual fun removeSuspension(interest: SelectInterest): Continuation<Unit>? {
        return removeSuspension(interest.ordinal)
    }

    actual fun removeSuspension(interestOrdinal: Int): Continuation<Unit>? {
        val cont = suspensions[interestOrdinal]
        suspensions[interestOrdinal] = null
        return cont
    }
}