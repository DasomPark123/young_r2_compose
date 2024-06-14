package com.young.r2.compose.repository

import com.young.r2.compose.core.common.network.NetworkFetcher
import com.young.r2.compose.domain.model.product.ProductInfo

interface ProductRepository {
    suspend fun getProductInfoByProductName(product: String): NetworkFetcher<ProductInfo>
    suspend fun getProductInfoByProductReportNo(reportNo: String): NetworkFetcher<ProductInfo>
}