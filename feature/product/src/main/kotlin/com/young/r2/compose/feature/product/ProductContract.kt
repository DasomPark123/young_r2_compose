package com.young.r2.compose.feature.product

import com.young.r2.compose.core.common.base.ViewEvent
import com.young.r2.compose.core.common.base.ViewState
import com.young.r2.compose.domain.model.product.ProductInfo

class ProductContract {

    data class State(
        val productInfo: ProductInfo
    ): ViewState

    sealed class Event: ViewEvent {
        //TODO: 추가 예정
    }
}