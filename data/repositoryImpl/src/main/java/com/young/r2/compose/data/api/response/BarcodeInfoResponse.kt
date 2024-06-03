package com.young.r2.compose.data.api.response

import com.google.gson.annotations.SerializedName

data class BarcodeInfoResponse(

    @SerializedName("total_count")
    val totalCount: String = "",

    @SerializedName("row")
    val row: List<BarcodeListItemResponse> = listOf(),

    @SerializedName("RESULT")
    val result: BarcodeResultResponse = BarcodeResultResponse()
)
