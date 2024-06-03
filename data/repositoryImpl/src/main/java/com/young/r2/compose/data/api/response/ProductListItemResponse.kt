package com.young.r2.compose.data.api.response

import android.os.Parcelable

data class ProductListItemResponse(

    val allergy: String = "",

    val barcode: String = "",

    val capacity: String = "",

    val imgUrl1: String = "",

    val imgUrl2: String = "",

    val manufacture: String = "",

    val nutrient: String = "",

    val productKind: String = "",

    val productKindState: String = "",

    val productListNum: String = "",

    val productListReportNo: String = "",

    val productGb: String = "",

    val rawMaterial: String = "",

    val rNum: String = "",

    val seller: String = ""
): Parcelable
