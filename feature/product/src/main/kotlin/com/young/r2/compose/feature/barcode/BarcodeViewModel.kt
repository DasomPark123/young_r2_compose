package com.young.r2.compose.feature.barcode

import com.young.r2.compose.core.common.base.BaseViewModel
import com.young.r2.compose.domain.usecase.GetProductNameByBarcodeUseCase
import javax.inject.Inject

class BarcodeViewModel @Inject constructor(
    private val getProductNameByBarcodeUseCase: GetProductNameByBarcodeUseCase
): BaseViewModel<BarcodeContract.State, BarcodeContract.Event>() {

    init { initializeState() }

    override fun setInitialState(): BarcodeContract.State {
        TODO("Not yet implemented")
    }
}