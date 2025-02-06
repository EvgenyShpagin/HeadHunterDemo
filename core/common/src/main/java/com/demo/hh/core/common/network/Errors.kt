package com.demo.hh.core.common.network


sealed class ConnectionError : Error() {
    data object NoInternet : ConnectionError()
    data object ServerError : ConnectionError()
    data object Other : ConnectionError()

    protected fun readResolve(): Any = this
}

sealed class FetchError : Error() {
    data object NoInternet : FetchError()
    data object ServerError : FetchError()
    data object OtherConnectionError : FetchError()
    data object NotFound : FetchError()

    protected fun readResolve(): Any = this
}