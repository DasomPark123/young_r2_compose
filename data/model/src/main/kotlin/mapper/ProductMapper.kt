package mapper

import findWordBetweenBracket
import product.ProductInfo
import product.ProductInfoDTO
import product.ProductListItem
import product.ProductListItemDTO
import removeKorean

class ProductMapper {
    fun ProductInfoDTO.toProductInfo(): ProductInfo {
        return ProductInfo(
            list = this.list.toProductListItem(),
            totalCount = this.totalCount,
            pageNo = this.pageNo,
            resultCode = this.resultCode,
            resultMessage = this.resultMessage,
            numOfRows = this.numOfRows
        )
    }

    private fun List<ProductListItemDTO>.toProductListItem(): List<ProductListItem> {
        if (this.isEmpty()) return listOf()

        val parsedDataListModel: ArrayList<ProductListItem> = ArrayList()
        for (productInfo in this) {
            val parsedProductInfo = ProductListItem()

            parsedProductInfo.productId = productInfo.prdlstReportNo
            parsedProductInfo.product = productInfo.prdlstNm
            parsedProductInfo.seller = productInfo.manufacture.split(" ", "/", "_", ",")[0]
            parsedProductInfo.imageUrl = productInfo.imgurl1
            if (productInfo.capacity.contains("(")) {
                parsedProductInfo.totalContent =
                    productInfo.capacity.substring(0, productInfo.capacity.indexOf("("))
                parsedProductInfo.calorie =
                    productInfo.capacity.findWordBetweenBracket().replace(">", "")
            } else {
                parsedProductInfo.totalContent = productInfo.capacity.replace(">", "")
            }

            if (productInfo.nutrient.isNotEmpty() && productInfo.nutrient != UNKNOWN) {
                val nutrientArr = productInfo.nutrient.split(",")
                for (i in nutrientArr.indices) {
                    when {
                        nutrientArr[i].contains(CALORIE) -> {
                            if (!parsedProductInfo.calorie.contains(CALORIE)) {
                                val calArr = nutrientArr[i].split(" ")
                                for (i in calArr.indices) {
                                    if (calArr[i].contains("kcal")) {
                                        when {
                                            calArr[i].length == 4 && i != 0 -> { // ex) 250 kcal : 숫자와 kcal 사이에 띄어쓰기가 있는 경우
                                                parsedProductInfo.calorie =
                                                    (calArr[i - 1].removeKorean() + calArr[i].removeKorean()).replace(">","")
                                            }
                                            calArr[i].contains("(") && calArr[i].contains(")") -> { // ex) 열량(kcal)350 : kcal 이 괄호안에 있는 경우
                                                parsedProductInfo.calorie = calArr[i].replace(">","")
                                            }
                                            else -> {
                                                parsedProductInfo.calorie =
                                                    calArr[i].removeKorean().substring(0, calArr[i].removeKorean().indexOf(CALORIE) + 4).replace(">","")
                                            }
                                        }
                                        break
                                    }
                                }
                            }
                        }
                        nutrientArr[i].contains(CARBOHYDRATE) -> {
                            val carArr = nutrientArr[i].split(" ")
                            for (word in carArr) {
                                if (word.contains("g")) {
                                    parsedProductInfo.carbohydrate = word.removeKorean().replace(">","")
                                    break
                                }
                            }
                        }
                        nutrientArr[i].contains(SUGAR) -> {
                            val sugarArr = nutrientArr[i].split(" ")
                            for (word in sugarArr) {
                                if (word.contains("g")) {
                                    parsedProductInfo.sugars = word.removeKorean().replace(">","")
                                    break
                                }
                            }
                        }
                        nutrientArr[i].contains(SUGAR) -> {
                            val sugarArr = nutrientArr[i].split(" ")
                            for (word in sugarArr) {
                                if (word.contains("g")) {
                                    parsedProductInfo.sugars = word.removeKorean().replace(">","")
                                    break
                                }
                            }
                        }
                        nutrientArr[i].contains(PROTEIN) -> {
                            val proteinArr = nutrientArr[i].split(" ")
                            for (word in proteinArr) {
                                if (word.contains("g")) {
                                    parsedProductInfo.protein = word.removeKorean().replace(">","")
                                    break
                                }
                            }
                        }
                        nutrientArr[i].contains(FAT) -> {
                            when {
                                nutrientArr[i].contains(SATURATED_FAT) -> {
                                    val satArr = nutrientArr[i].split(" ")
                                    for (word in satArr) {
                                        if (word.contains("g")) {
                                            parsedProductInfo.saturatedFat =
                                                word.removeKorean().replace(">","")
                                            break
                                        }
                                    }
                                }
                                nutrientArr[i].contains(TRANS_FAT) -> {
                                    val transArr = nutrientArr[i].split(" ")
                                    for (word in transArr) {
                                        if (word.contains("g")) {
                                            parsedProductInfo.transFat = word.removeKorean().replace(">","")
                                            break
                                        }
                                    }
                                }
                                else -> {
                                    val fatArr = nutrientArr[i].split(" ")
                                    for (word in fatArr) {
                                        if (word.contains("g")) {
                                            parsedProductInfo.fat = word.removeKorean().replace(">","")
                                            break
                                        }
                                    }
                                }
                            }
                        }
                        nutrientArr[i].contains(CARBOHYDRATE) -> {
                            val cholArr = nutrientArr[i].split(" ")
                            for (word in cholArr) {
                                if (word.contains("g")) {
                                    parsedProductInfo.cholesterol = word.removeKorean().replace(">","")
                                    break
                                }
                            }
                        }
                        nutrientArr[i].contains(SALT) -> {
                            val saltArr = nutrientArr[i].split(" ")
                            for (word in saltArr) {
                                if (word.contains("g")) {
                                    parsedProductInfo.salt = word.removeKorean().replace(">","")
                                    break
                                }
                            }
                        }
                    }
                }
                parsedDataListModel.add(parsedProductInfo)
            }
        }
        return parsedDataListModel
    }

    companion object {
        const val CALORIE = "kcal"
        const val CARBOHYDRATE = "탄수화물"
        const val SUGAR = "당류"
        const val PROTEIN = "단백질"
        const val FAT = "지방"
        const val SATURATED_FAT = "포화지방"
        const val TRANS_FAT = "트랜스지방"
        const val CHOLESTEROL = "콜레스테롤"
        const val SALT = "나트륨"
        const val UNKNOWN = "알수없음"
    }
}