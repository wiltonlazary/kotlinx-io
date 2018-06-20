package kotlinx.io.net.selector.utils

import kotlinx.io.net.selector.*

internal class SelectablesMap {
    private var table = arrayOfNulls<Selectable>(65536)
    private var factor = 0

    var size = 0
        private set

    fun put(v: Selectable) {
        val k = v.id
        val index = index(k)
        val table = table
        val existing = table[index]
        if (existing == null) {
            table[index] = v
            v.localHeapIndex = index
            size++
            return
        } else if (existing.id == k) {
            table[index] = v
            v.localHeapIndex = index
            return
        }

        return putCollide(v)
    }

    operator fun get(k: Int): Selectable? {
        val index = index(k)
        val table = table
        val v = table[index]
        if (v != null && v.id == k) return v

        return getByNext(index, k, table)
    }

    operator fun contains(s: Selectable): Boolean = get(s.id) === s

    private fun getByNext(index: Int, k: Int, table: Array<Selectable?>): Selectable? {
        val nextIndex = index(index + 1)
        val v = table[nextIndex]
        if (v != null && v.id == k) return v

        return null
    }

    fun remove(k: Int): Selectable? {
        val index = index(k)
        val v = table[index]
        if (v != null && v.id == k) {
            table[index] = null
            size--
            return v
        }

        val nextIndex = index(index + 1)
        val v2 = table[nextIndex]
        if (v2 != null && v2.id == k) {
            table[nextIndex] = null
            size--
            return v2
        }

        return null
    }

    fun remove(s: Selectable) = remove(s.id)

    fun nextKey(k: Int): Int {
        if (k == -1) {
            return firstKey()
        }

        var index = index(k)
        val table = table
        if (table[index]?.id != k) {
            index++
        }
        if (index >= table.size) return -1
        if (table[index]?.id != k) return -1
        index++

        while (index < table.size) {
            table[index]?.let { return it.id }
            index++
        }

        return -1
    }

    private fun firstKey(): Int {
        if (size == 0) return -1
        val table = table

        for (i in 0 until table.size) {
            return table[i]?.id ?: continue
        }

        throw IllegalStateException("size != 0 but no entries found")
    }

    private fun putCollide(v: Selectable) {
        val k = v.id
        val index = index(k)
        val table = table
        val nextIndex = index(index + 1)

        val existing = table[nextIndex]
        if (existing == null) {
            table[nextIndex] = v
            v.localHeapIndex = nextIndex
            size++
            return
        } else if (existing.id == k) {
            table[nextIndex] = v
            v.localHeapIndex = nextIndex
            return
        }

        rehash()
        return put(v)
    }

    private fun rehash() {
        if (factor == 4) throw IllegalStateException("Unable to grow hashtable")
        factor++

        val oldTable = table
        val oldSize = size

        table = arrayOfNulls(factorSize())
        size = 0

        if (size > 0) {
            for (e in oldTable) {
                if (e != null) {
                    put(e)
                }
            }
        }

        if (size != oldSize) {
            throw IllegalStateException("rehash failed: size != oldSize")
        }
    }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun index(k: Int) = when (factor) {
        0 -> k and 0xffff
        1 -> k and 0xfffff
        2 -> k and 0xffffff
        3 -> k and 0xfffffff
        4 -> k and 0x7fffffff
        else -> error("Unknown factor")
    }

    private fun factorSize() = when (factor) {
        0 -> 0xffff
        1 -> 0xfffff
        2 -> 0xffffff
        3 -> 0xfffffff
        4 -> 0x7fffffff
        else -> error("Unknown factor")
    }
}