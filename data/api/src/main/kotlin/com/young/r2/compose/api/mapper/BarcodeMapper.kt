package com.young.r2.compose.api.mapper

import com.young.r2.compose.api.response.BarcodeInfoResponse
import com.young.r2.compose.api.response.BarcodeItemResponse
import com.young.r2.compose.api.response.BarcodeResultResponse
import com.young.r2.compose.api.response.BarcodeServiceResponse
import com.young.r2.compose.domain.model.barcode.BarcodeInfo
import com.young.r2.compose.domain.model.barcode.BarcodeItem
import com.young.r2.compose.domain.model.barcode.BarcodeResult
import com.young.r2.compose.domain.model.barcode.BarcodeService

fun BarcodeServiceResponse.toData(): BarcodeService =
    BarcodeService(
        barcodeInfo = this.C005.toData()
    )

internal fun BarcodeInfoResponse.toData(): BarcodeInfo =
    BarcodeInfo(
        totalCount = this.totalCount,
        row = this.row.toData(),
        result = this.result.toData()
    )

internal fun List<BarcodeItemResponse>.toData(): List<BarcodeItem> {
    val barcodeItemList = ArrayList<BarcodeItem>()
    this.forEach {
        val barcodeItem = BarcodeItem().apply {
            closedBusinessData = it.closedBusinessData
            address = it.address
            productReportNo = it.productReportNo
            reportDate = it.reportDate
            productName = it.productName
            barcodeNo = it.barcodeNo
            expirationDate = it.expirationDate
            productType = it.productType
            companyName = it.companyName
            productionStopDate = it.productionStopDate
            sectors = it.sectors
        }
        barcodeItemList.add(barcodeItem)
    }
    return barcodeItemList
}

internal fun BarcodeResultResponse.toData(): BarcodeResult =
    BarcodeResult(
        msg = this.msg,
        code = this.code
    )
