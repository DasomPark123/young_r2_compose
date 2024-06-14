package com.young.r2.compose.data.repositoryImpl

import com.young.r2.compose.api.ProductApiService
import com.young.r2.compose.api.mapper.toData
import com.young.r2.compose.core.common.network.NetworkFetcher
import com.young.r2.compose.core.common.network.safeCall
import com.young.r2.compose.domain.model.product.ProductInfo
import com.young.r2.compose.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productInfoApi: ProductApiService
): ProductRepository {
    override suspend fun getProductInfoByProductName(product: String): NetworkFetcher<ProductInfo> {
        return safeCall {
            productInfoApi.getProductInfoByProductName(productListName = product).toData()
        }
    }

    override suspend fun getProductInfoByProductReportNo(reportNo: String): NetworkFetcher<ProductInfo> {
        return safeCall {
            productInfoApi.getProjectInfoByProductReportNo(productListReportNo = reportNo).toData()
        }
    }
}