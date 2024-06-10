package com.young.r2.compose.api.mapper

import com.young.r2.compose.api.response.ProductInfoResponse
import com.young.r2.compose.api.response.ProductItemResponse
import com.young.r2.compose.core.common.findWordBetweenBracket
import com.young.r2.compose.core.common.removeKorean
import com.young.r2.compose.domain.model.product.ProductInfo
import com.young.r2.compose.domain.model.product.ProductItem

internal fun ProductInfoResponse.toData(): ProductInfo =
    ProductInfo(
        list = this.list.toData(),
        totalCount = totalCount,
        pageNo = pageNo,
        resultCode = resultCode,
        numOfRows = numOfRows
    )

internal fun List<ProductItemResponse>.toData(): List<ProductItem> {
    if (this.isEmpty()) return listOf()

    val productItemList: ArrayList<ProductItem> = ArrayList()
    for (productItemResponse in this) {
        val productItem = ProductItem()
        if (productItemResponse.productListReportNo.isNotEmpty()) productItem.productId = productItemResponse.productListReportNo
        if (productItemResponse.productListNum.isNotEmpty()) productItem.product = productItemResponse.productListNum
        if (productItemResponse.manufacture.isNotEmpty()) productItem.seller = productItemResponse.manufacture.split(" ", "/", "_", ",")[0]
        if (productItemResponse.imgUrl1.isNotEmpty()) productItem.imageUrl = productItemResponse.imgUrl1
        if (productItemResponse.capacity.isNotEmpty()) {
            if (productItemResponse.capacity.contains("(")) {
                productItem.total_content =
                    productItemResponse.capacity.substring(0, productItemResponse.capacity.indexOf("("))
                productItem.calorie = findWordBetweenBracket(productItemResponse.capacity).replace(">","")
            } else {
                productItem.total_content = productItemResponse.capacity.replace(">","")
            }
        }

        if (productItemResponse.nutrient != ProductInfo.UNKNOWN) {
            val nutrientArr = productItemResponse.nutrient.split(",")
            for (i in nutrientArr.indices) {
                when {
                    nutrientArr[i].contains(ProductInfo.CALORIE) -> {
                        if (!productItem.calorie.contains(ProductInfo.CALORIE)) {
                            val calArr = nutrientArr[i].split(" ")
                            for (i in calArr.indices) {
                                if (calArr[i].contains("kcal")) {
                                    when {
                                        calArr[i].length == 4 && i != 0 -> { // ex) 250 kcal : 숫자와 kcal 사이에 띄어쓰기가 있는 경우
                                            productItem.calorie =
                                                (removeKorean(calArr[i - 1]) + removeKorean(
                                                    calArr[i]
                                                )).replace(">","")
                                        }
                                        calArr[i].contains("(") && calArr[i].contains(")") -> { // ex) 열량(kcal)350 : kcal 이 괄호안에 있는 경우
                                            productItem.calorie = calArr[i].replace(">","")
                                        }
                                        else -> {
                                            productItem.calorie =
                                                removeKorean(calArr[i]).substring(
                                                    0,
                                                    removeKorean(calArr[i])
                                                        .indexOf(ProductInfo.CALORIE) + 4
                                                ).replace(">","")
                                        }
                                    }
                                    break
                                }
                            }
                        }
                    }
                    nutrientArr[i].contains(ProductInfo.CARBOHYDRATE) -> {
                        val carArr = nutrientArr[i].split(" ")
                        for (word in carArr) {
                            if (word.contains("g")) {
                                productItem.carbohydrate = removeKorean(word).replace(">","")
                                break
                            }
                        }
                    }
                    nutrientArr[i].contains(ProductInfo.SUGAR) -> {
                        val sugarArr = nutrientArr[i].split(" ")
                        for (word in sugarArr) {
                            if (word.contains("g")) {
                                productItem.sugars = removeKorean(word).replace(">","")
                                break
                            }
                        }
                    }
                    nutrientArr[i].contains(ProductInfo.SUGAR) -> {
                        val sugarArr = nutrientArr[i].split(" ")
                        for (word in sugarArr) {
                            if (word.contains("g")) {
                                productItem.sugars = removeKorean(word).replace(">","")
                                break
                            }
                        }
                    }
                    nutrientArr[i].contains(ProductInfo.PROTEIN) -> {
                        val proteinArr = nutrientArr[i].split(" ")
                        for (word in proteinArr) {
                            if (word.contains("g")) {
                                productItem.protein = removeKorean(word).replace(">","")
                                break
                            }
                        }
                    }
                    nutrientArr[i].contains(ProductInfo.FAT) -> {
                        when {
                            nutrientArr[i].contains(ProductInfo.SATURATED_FAT) -> {
                                val satArr = nutrientArr[i].split(" ")
                                for (word in satArr) {
                                    if (word.contains("g")) {
                                        productItem.saturatedFat =
                                            removeKorean(word).replace(">","")
                                        break
                                    }
                                }
                            }
                            nutrientArr[i].contains(ProductInfo.TRANS_FAT) -> {
                                val transArr = nutrientArr[i].split(" ")
                                for (word in transArr) {
                                    if (word.contains("g")) {
                                        productItem.transFat = removeKorean(word).replace(">","")
                                        break
                                    }
                                }
                            }
                            else -> {
                                val fatArr = nutrientArr[i].split(" ")
                                for (word in fatArr) {
                                    if (word.contains("g")) {
                                        productItem.fat = removeKorean(word).replace(">","")
                                        break
                                    }
                                }
                            }
                        }
                    }
                    nutrientArr[i].contains(ProductInfo.CARBOHYDRATE) -> {
                        val cholArr = nutrientArr[i].split(" ")
                        for (word in cholArr) {
                            if (word.contains("g")) {
                                productItem.cholesterol = removeKorean(word).replace(">","")
                                break
                            }
                        }
                    }
                    nutrientArr[i].contains(ProductInfo.SALT) -> {
                        val saltArr = nutrientArr[i].split(" ")
                        for (word in saltArr) {
                            if (word.contains("g")) {
                                productItem.salt = removeKorean(word).replace(">","")
                                break
                            }
                        }
                    }
                }
            }
            productItemList.add(productItem)
        }
    }
    //Log.d(tag, "Paging data : $parsedDataList")
    return productItemList
}

