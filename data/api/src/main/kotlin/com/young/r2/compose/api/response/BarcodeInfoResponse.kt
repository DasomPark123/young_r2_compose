package com.young.r2.compose.api.response

import com.google.gson.annotations.SerializedName

data class BarcodeInfoResponse(

    @SerializedName("total_count")
    val totalCount: String = "",

    @SerializedName("row")
    val row: List<BarcodeItemResponse> = listOf(),

    @SerializedName("RESULT")
    val result: BarcodeResultResponse = BarcodeResultResponse()
)
