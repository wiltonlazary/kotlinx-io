package kotlinx.io.net.selector

import java.util.concurrent.atomic.*
import kotlin.coroutines.experimental.*

internal actual class InterestSuspensionsMap {
    @Volatile
    @Suppress("unused")
    private var readHandlerReference: Continuation<Unit>? = null

    @Volatile
    @Suppress("unused")
    private var writeHandlerReference: Continuation<Unit>? = null

    @Volatile
    @Suppress("unused")
    private var connectHandlerReference: Continuation<Unit>? = null

    @Volatile
    @Suppress("unused")
    private var acceptHandlerReference: Continuation<Unit>? = null

    actual fun addSuspension(interest: SelectInterest, continuation: Continuation<Unit>) {
        val updater = updater(interest)

        if (!updater.compareAndSet(this, null, continuation)) {
            throw IllegalStateException("Handler for ${interest.name} is already registered")
        }
    }

    @Suppress("LoopToCallChain")
    actual inline fun invokeForEachPresent(readyOps: Int, block: Continuation<Unit>.() -> Unit) {
        val flags = SelectInterest.flags

        for (ordinal in 0 until flags.size) {
            if (flags[ordinal] and readyOps != 0) {
                removeSuspension(ordinal)?.block()
            }
        }
    }

    actual inline fun invokeForEachPresent(block: Continuation<Unit>.(SelectInterest) -> Unit) {
        for (interest in SelectInterest.AllInterests) {
            removeSuspension(interest)?.run { block(interest) }
        }
    }

    actual fun removeSuspension(interest: SelectInterest): Continuation<Unit>? =
            updater(interest).getAndSet(this, null)

    actual fun removeSuspension(interestOrdinal: Int): Continuation<Unit>? =
            updaters[interestOrdinal].getAndSet(this, null)

    override fun toString(): String {
        return "R $readHandlerReference W $writeHandlerReference C $connectHandlerReference A $acceptHandlerReference"
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        private val updaters = SelectInterest.AllInterests.map { interest ->
            AtomicReferenceFieldUpdater.newUpdater(InterestSuspensionsMap::class.java,
                    Continuation::class.java, "${interest.name.toLowerCase()}HandlerReference")
                    as AtomicReferenceFieldUpdater<InterestSuspensionsMap, Continuation<Unit>?>
        }.toTypedArray()

        private fun updater(interest: SelectInterest): AtomicReferenceFieldUpdater<InterestSuspensionsMap,
                Continuation<Unit>?> = updaters[interest.ordinal]
    }
}