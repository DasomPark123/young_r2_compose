package com.young.r2.compose.data.api

import retrofit2.http.GET
import retrofit2.http.Path

interface BarcodeApiService {
    @GET("/api/{serviceKey}/C005/{returnType}/1/1/BAR_CD={barcodeNo}")
    suspend fun getProductByBarcode(
        @Path("serviceKey") serviceKey: String = "",
        @Path("returnType") returnType: String = "json",
        @Path("barcodeNo") barcodeNum: String
    ) //TODO: 리턴 타입이 추가되어야함
}