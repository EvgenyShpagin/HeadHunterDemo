package com.demo.hh.core.model

sealed class Salary {
    data class Range(
        val fromAmount: Int?,
        val toAmount: Int?,
        val currencySign: Char = '₽'
    ) : Salary()

    data class Exact(
        val amount: Int,
        val currencySign: Char = '₽'
    ) : Salary()

    data object Unspecified : Salary()
}