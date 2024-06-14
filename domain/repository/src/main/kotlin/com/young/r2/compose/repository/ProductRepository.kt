package com.young.r2.compose.repository

import com.young.r2.compose.core.common.network.NetworkFetcher
import com.young.r2.compose.domain.model.product.ProductInfo
import com.young.r2.compose.domain.model.product.ProductItem

interface ProductRepository {
    suspend fun getProductInfoListByProductName(product: String): NetworkFetcher<ProductInfo>
    suspend fun getProductInfoByProductReportNo(reportNo: String): NetworkFetcher<ProductInfo>
}