package com.young.r2.compose.domain.usecase

import com.young.r2.compose.core.common.network.NetworkFetcher
import com.young.r2.compose.domain.model.product.ProductInfo
import com.young.r2.compose.repository.ProductRepository
import javax.inject.Inject

//TODO: 단순 wrapper 클래스. 좀 더 간략하게 줄여보자 (다른 usecase 도 동일)
class GetProductInfoByProductNameUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(productName: String): NetworkFetcher<ProductInfo> =
        repository.getProductInfoByProductName(productName)
}