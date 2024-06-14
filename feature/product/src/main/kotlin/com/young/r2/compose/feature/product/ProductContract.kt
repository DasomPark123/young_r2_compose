package com.young.r2.compose.feature.product

import com.young.r2.compose.core.common.base.ViewState

class ProductContract {
    data class State(
        //TODO: 데이터 추가 필요
    ): ViewState

    //TODO: ViewEvent 정의 필요
    sealed class Event: ViewEvent {

    }
}