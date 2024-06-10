package com.young.r2.compose.data.repositoryImpl

import com.young.r2.compose.api.ProductApiService
import com.young.r2.compose.domain.model.product.ProductInfo
import com.young.r2.compose.domain.model.product.ProductItem
import com.young.r2.compose.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productInfoApi: ProductApiService
): ProductRepository {
    override fun getProductInfoListByProductName(product: String): List<ProductItem> {
        TODO("Not yet implemented")
    }

    override fun getProductInfoByProductReportNo(reportNo: String): ProductInfo {
        TODO("Not yet implemented")
    }
}