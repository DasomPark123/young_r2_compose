package com.young.r2.compose.repository

import com.young.r2.compose.domain.model.product.ProductInfo
import com.young.r2.compose.domain.model.product.ProductItem

interface ProductRepository {
    fun getProductInfoListByProductName(product: String): List<ProductItem>
    fun getProductInfoByProductReportNo(reportNo: String): ProductInfo
}