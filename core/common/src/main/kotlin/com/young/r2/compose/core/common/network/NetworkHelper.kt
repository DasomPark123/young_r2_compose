package com.young.r2.compose.core.common.network

suspend fun <T> safeCall(apiCall: suspend () -> T): NetworkFetcher<T> {
    return try {
        NetworkFetcher.success(apiCall.invoke())
    } catch (throwable: Throwable) {
        NetworkFetcher.failure(throwable)
    }
}

