package com.young.r2.compose.repository

import com.young.r2.compose.core.common.network.NetworkFetcher
import com.young.r2.compose.domain.model.barcode.BarcodeService

interface BarcodeRepository {
    suspend fun getProductNameByBarcode(barcodeNo: String): NetworkFetcher<BarcodeService>
}