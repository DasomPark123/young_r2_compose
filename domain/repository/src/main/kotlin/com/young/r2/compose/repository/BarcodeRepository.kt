package com.young.r2.compose.repository

import com.young.r2.compose.domain.model.barcode.BarcodeService

interface BarcodeRepository {
    fun getProductNameByBarcode(barcodeNo: String): BarcodeService
}