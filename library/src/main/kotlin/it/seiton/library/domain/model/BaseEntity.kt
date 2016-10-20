package it.seiton.library.domain.model

/**
 * Created by lukasw44 on 18/10/2016.
 */
open class BaseEntity(val id: Int) {

    fun id(): Int = id

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as BaseEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}