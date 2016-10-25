package it.seiton.library.infrastructure.sql

/**
 * Created by lukasw44 on 18/10/2016.
 */
class Sort(val orders: List<Order>) {

    constructor(vararg orders: Order) : this(orders.toList())

    constructor(property: String) : this(Order(property))

    constructor(vararg properties: String) : this(properties.map { p -> Order(p) })

    constructor(property: String, direction: Sort.Direction) : this(Order(property, direction))

    enum class Direction {

        ASC, DESC;

        fun isAscending(): Boolean {
            return this == ASC
        }

        fun isDescending(): Boolean {
            return this == DESC
        }
    }

    class Order(val property: String, val direction: Direction = Direction.ASC) {

        override fun toString(): String {
            return property + " " + direction.name
        }

        fun getOrderBy(): String {
            return "$property ${direction.name}"
        }
    }

    fun getOrdersBy(): String {
        return orders.map(Order::getOrderBy).joinToString(",")
    }
}