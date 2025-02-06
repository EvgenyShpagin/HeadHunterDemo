package com.demo.hh.core.model

sealed class Salary {
    data class Range(val fromAmount: Int?, val toAmount: Int?) : Salary()
    data class Exact(val amount: Int) : Salary()
    data object Unspecified : Salary()
}