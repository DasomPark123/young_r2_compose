package com.young.r2.compose.data.repositoryImpl

import com.young.r2.compose.api.ProductApiService
import com.young.r2.compose.core.common.network.NetworkFetcher
import com.young.r2.compose.core.common.network.safeCall
import com.young.r2.compose.domain.model.product.ProductInfo
import com.young.r2.compose.domain.model.product.ProductItem
import com.young.r2.compose.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productInfoApi: ProductApiService
): ProductRepository {
    override suspend fun getProductInfoListByProductName(product: String): NetworkFetcher<List<ProductItem>> {
        return safeCall { //TODO: 타입 수정 필요
            productInfoApi.getProductInfoByProductName(productListName = product)
        }
    }

    override suspend fun getProductInfoByProductReportNo(reportNo: String): NetworkFetcher<ProductInfo> {
        return safeCall { //TODO: 타입 수정 필요
            productInfoApi.getProjectInfoByProductReportNo(productListReportNo = reportNo)
        }
    }
}