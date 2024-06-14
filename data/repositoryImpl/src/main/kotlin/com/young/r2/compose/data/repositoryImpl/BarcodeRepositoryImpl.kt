package com.young.r2.compose.data.repositoryImpl

import com.young.r2.compose.api.BarcodeApiService
import com.young.r2.compose.api.mapper.toData
import com.young.r2.compose.core.common.network.NetworkFetcher
import com.young.r2.compose.core.common.network.safeCall
import com.young.r2.compose.domain.model.barcode.BarcodeService
import com.young.r2.compose.repository.BarcodeRepository
import javax.inject.Inject

class BarcodeRepositoryImpl @Inject constructor(
    private val barcodeApi: BarcodeApiService
): BarcodeRepository {
    override suspend fun getProductNameByBarcode(barcodeNo: String): NetworkFetcher<BarcodeService> {
        return safeCall {
            barcodeApi.getProductByBarcode(barcodeNum = barcodeNo).toData()
        }
    }
}