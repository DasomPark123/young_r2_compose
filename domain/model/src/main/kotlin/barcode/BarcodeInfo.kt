package barcode

data class BarcodeInfo(
    val totalCount : String = "",
    val row : List<BarcodeListItem> = listOf(),
    val result : BarcodeResult
)
