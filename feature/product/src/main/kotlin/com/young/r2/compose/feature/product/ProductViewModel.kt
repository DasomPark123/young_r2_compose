package com.young.r2.compose.feature.product

import com.young.r2.compose.core.common.base.BaseViewModel
import com.young.r2.compose.domain.usecase.GetProductInfoByProductNameUseCase
import com.young.r2.compose.domain.usecase.GetProductInfoByReportNoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductInfoByProductNameUseCase: GetProductInfoByProductNameUseCase,
    private val getProductInfoByReportNoUseCase: GetProductInfoByReportNoUseCase
): BaseViewModel<ProductContract.State, ProductContract.Event>() {

    init { initializeState() }

    override fun setInitialState(): ProductContract.State {
        TODO("Not yet implemented")
    }
}