package com.young.r2.compose.feature.barcode

import com.young.r2.compose.core.common.base.ViewEvent
import com.young.r2.compose.core.common.base.ViewState
import com.young.r2.compose.domain.model.barcode.BarcodeService

class BarcodeContract {

    data class State(
        val barcodeService: BarcodeService
    ): ViewState

    sealed class Event: ViewEvent {
        //TODO: 추가 예정
    }
}