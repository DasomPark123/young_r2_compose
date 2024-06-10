package com.young.r2.compose.domain.model.barcode

data class BarcodeInfo(
    val totalCount: String = "",
    val row: List<BarcodeItem> = listOf(),
    val result: BarcodeResult = BarcodeResult()
)
