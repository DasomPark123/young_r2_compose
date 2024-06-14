package com.young.r2.compose.domain.usecase

import com.young.r2.compose.core.common.network.NetworkFetcher
import com.young.r2.compose.domain.model.barcode.BarcodeService
import com.young.r2.compose.repository.BarcodeRepository
import javax.inject.Inject

class GetProductNameByBarcodeUseCase @Inject constructor(
    private val repository: BarcodeRepository
) {
    suspend operator fun invoke(barcodeNo: String): NetworkFetcher<BarcodeService> =
        repository.getProductNameByBarcode(barcodeNo)
}