package kotlinx.io.net.selector.utils

import java.util.concurrent.atomic.*
import kotlin.coroutines.experimental.*

internal actual abstract class ConditionImpl<T> actual constructor() : Condition {
    @Volatile
    private var cond: Continuation<T>? = null

    protected actual var continuation: Continuation<T>?
        get() = cond
        set(value) {
            if (!updater.compareAndSet(this, null, value)) {
                throw IllegalStateException("Await operation is already in progress")
            }
        }

    protected actual fun removeContinuation(c: Continuation<T>): Boolean {
        return updater.compareAndSet(this, c, null)
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        private val updater = AtomicReferenceFieldUpdater.newUpdater<Condition, Continuation<*>>(Condition::class.java,
                Continuation::class.java, ConditionImpl<*>::cond.name)
                as AtomicReferenceFieldUpdater<Condition, Continuation<*>?>
    }
}