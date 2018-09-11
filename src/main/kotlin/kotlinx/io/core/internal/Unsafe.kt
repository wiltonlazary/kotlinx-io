package kotlinx.io.core.internal

/**
 * API marked with this annotation is internal and extremely fragile and not intended to be used by library users.
 * Such API could be changed without notice including rename, removal and behaviour change.
 * Also using API marked with this annotation could cause data loss or any other damage.
 */
@Experimental(level = Experimental.Level.ERROR)
annotation class DangerousInternalIoApi
