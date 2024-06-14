package com.young.r2.compose.domain.usecase

import com.young.r2.compose.core.common.network.NetworkFetcher
import com.young.r2.compose.domain.model.product.ProductInfo
import com.young.r2.compose.repository.ProductRepository
import javax.inject.Inject

class GetProductInfoByReportNoUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(reportNo: String): NetworkFetcher<ProductInfo> =
        repository.getProductInfoByProductReportNo(reportNo)
}