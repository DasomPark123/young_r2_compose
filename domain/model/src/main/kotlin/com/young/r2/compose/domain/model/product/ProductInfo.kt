package com.young.r2.compose.domain.model.product

data class ProductInfo(
    val list : List<ProductItem> = listOf(),
    val totalCount : String = "",
    val pageNo : String = "",
    val resultCode : String = "",
    val resultMessage : String = "",
    val numOfRows : String = ""
) {
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
