package com.demo.hh.core.model

data class Date(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int
) {
    init {
        require(year > 0)
        require(month in 0 until 12)
        require(dayOfMonth in 0 until 31)
    }

    override fun hashCode(): Int {
        var result = year
        result = 31 * result + month
        result = 31 * result + dayOfMonth
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Date

        if (year != other.year) return false
        if (month != other.month) return false
        if (dayOfMonth != other.dayOfMonth) return false

        return true
    }
}