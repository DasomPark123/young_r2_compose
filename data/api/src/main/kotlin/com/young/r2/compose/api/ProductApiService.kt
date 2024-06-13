package com.young.r2.compose.api

import com.young.r2.compose.api.response.ProductInfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiService {
    //TODO : api 하나로 처리할 수 있을지 고민이 필요하다

    @GET("/B553748/CertImgListService/getCertImgListService")
    suspend fun getProductInfoByProductName(
        @Query("ServiceKey") serviceKey: String = "",
        @Query("prdlstNm") productListName: String,
        @Query("pageNo") pageNo: String = "1",
        @Query("numberOfRows") numberOfRows: String = "1",
        @Query("returnType") returnType: String = "json"
    ): ProductInfoResponse

    @GET("/B553748/CertImgListService/getCertImgListService")
    suspend fun getProjectInfoByProductReportNo(
        @Query("ServiceKey") serviceKey: String = "",
        @Query("prdlstReportNo") productListReportNo: String,
        @Query("pageNo") pageNo: String = "1",
        @Query("numberOfRows") numberOfRows: String = "1",
        @Query("returnType") returnType: String = "json"
    ): ProductInfoResponse
}