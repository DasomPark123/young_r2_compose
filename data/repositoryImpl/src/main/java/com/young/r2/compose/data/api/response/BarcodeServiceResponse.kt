package com.young.r2.compose.data.api.response

import com.google.gson.annotations.SerializedName

data class BarcodeServiceResponse(
    @SerializedName("C005")
    val C005: BarcodeInfoResponse = BarcodeInfoResponse()
)
