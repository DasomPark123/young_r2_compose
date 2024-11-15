package product

data class ProductInfo(
    val list : List<ProductListItem> = listOf(),
    val totalCount : String = "",
    val pageNo : String = "",
    val resultCode : String = "",
    val resultMessage : String = "",
    val numOfRows : String = ""
)
