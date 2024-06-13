package com.young.r2.compose.core.common.network

sealed class NetworkFetcher<out T> {
    data class Progress private constructor(var loading: Boolean): NetworkFetcher<Nothing>() {
        companion object {
            fun create(loading: Boolean): Progress = Progress(loading)
        }
    }

    data class Success<T> private constructor(var data: T): NetworkFetcher<T>() {
        companion object {
            fun <T> create(data: T): NetworkFetcher<T> = Success(data)
        }
    }

    data class Failure(val e: Throwable): NetworkFetcher<Nothing>() {
        companion object {
            fun create(e: Throwable): NetworkFetcher<Nothing> = Failure(e)
        }
    }

    data class ApiFailure(val res: Int, val msg: String): NetworkFetcher<Nothing>() {
        companion object {
            fun create(res: Int, msg: String): NetworkFetcher<Nothing> = ApiFailure(res, msg)
        }
    }

    companion object {
        fun loading(isLoading: Boolean): NetworkFetcher<Nothing> = Progress.create(isLoading)
        fun <T> success(data: T): NetworkFetcher<T> = Success.create(data)
        fun failure(e: Throwable): NetworkFetcher<Nothing> = Failure.create(e)
        fun apiFailure(res: Int, msg: String): NetworkFetcher<Nothing> = ApiFailure.create(res, msg)
    }
}
