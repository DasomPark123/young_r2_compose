package com.young.r2.compose.data.api.response

import com.google.gson.annotations.SerializedName

data class ProductInfoResponse(

    @SerializedName("list")
    val list: List<ProductListItemResponse> = listOf(),

    @SerializedName("totalCount")
    val totalCount: String = "",

    @SerializedName("pageNo")
    val pageNo: String = "",

    @SerializedName("resultCode")
    val resultCode: String = "",

    @SerializedName("resultMessage")
    val resultMessage: String = "",

    @SerializedName("numOfRows")
    val numOfRows: String = ""
)
