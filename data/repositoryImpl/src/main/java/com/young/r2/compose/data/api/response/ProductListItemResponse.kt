package com.young.r2.compose.data.api.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductListItemResponse(

    @SerializedName("allergy")
    val allergy: String = "",

    @SerializedName("barcode")
    val barcode: String = "",

    @SerializedName("capacity")
    val capacity: String = "",

    @SerializedName("imgurl1")
    val imgUrl1: String = "",

    @SerializedName("imgurl2")
    val imgUrl2: String = "",

    @SerializedName("manufacture")
    val manufacture: String = "",

    @SerializedName("nutrient")
    val nutrient: String = "",

    @SerializedName("prdkind")
    val productKind: String = "",

    @SerializedName("prdkindstate")
    val productKindState: String = "",

    @SerializedName("prdlstNm")
    val productListNum: String = "",

    @SerializedName("prdlstReportNo")
    val productListReportNo: String = "",

    @SerializedName("productGb")
    val productGb: String = "",

    @SerializedName("rawmtrl")
    val rawMaterial: String = "",

    @SerializedName("rnum")
    val rNum: String = "",

    @SerializedName("seller")
    val seller: String = ""
): Parcelable
