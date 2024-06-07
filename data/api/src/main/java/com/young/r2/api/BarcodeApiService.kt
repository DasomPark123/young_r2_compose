package com.young.r2.api

import com.young.r2.api.response.BarcodeServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BarcodeApiService {
    @GET("/api/{serviceKey}/C005/{returnType}/1/1/BAR_CD={barcodeNo}")
    suspend fun getProductByBarcode(
        @Path("serviceKey") serviceKey: String = "",
        @Path("returnType") returnType: String = "json",
        @Path("barcodeNo") barcodeNum: String
    ): BarcodeServiceResponse
}