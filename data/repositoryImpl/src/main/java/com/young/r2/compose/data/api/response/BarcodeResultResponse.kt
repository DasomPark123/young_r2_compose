package com.young.r2.compose.data.api.response

import com.google.gson.annotations.SerializedName

data class BarcodeResultResponse(

    @SerializedName("MSG")
    val msg: String = "",

    @SerializedName("CODE")
    val code: String = ""
)
