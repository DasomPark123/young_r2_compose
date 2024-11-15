package mapper

import barcode.BarcodeInfo
import barcode.BarcodeInfoDTO
import barcode.BarcodeListItem
import barcode.BarcodeListItemDTO
import barcode.BarcodeResult
import barcode.BarcodeResultDTO
import barcode.BarcodeService
import barcode.BarcodeServiceDTO

class BarcodeMapper {
    fun BarcodeServiceDTO.toBarcodeService(): BarcodeService {
        return BarcodeService(COO5 = this.COO5.toBarcodeInfo())
    }

    private fun BarcodeInfoDTO.toBarcodeInfo(): BarcodeInfo {
        return BarcodeInfo(
            totalCount = this.totalCount,
            row = this.row.toBarcodeListItem(),
            result = this.result.toBarcodeResult()
        )
    }

    private fun BarcodeResultDTO.toBarcodeResult(): BarcodeResult {
        return BarcodeResult(
            msg = this.msg,
            code = this.code
        )
    }

    private fun List<BarcodeListItemDTO>.toBarcodeListItem(): List<BarcodeListItem> {
        val parsedList: ArrayList<BarcodeListItem> = ArrayList()
        for (barcodeItem in this) {
            val parsedBarcodeItem = BarcodeListItem(
                closedBusinessData = barcodeItem.closedBusinessData,
                address = barcodeItem.address,
                productReportNo = barcodeItem.productReportNo,
                reportDate = barcodeItem.reportDate,
                productName = barcodeItem.productName,
                barcodeNo = barcodeItem.barcodeNo,
                expirationDate = barcodeItem.expirationDate,
                productType = barcodeItem.productType,
                companyName = barcodeItem.companyName,
                productionStopDate = barcodeItem.productionStopDate,
                sectors = barcodeItem.sectors
            )
            parsedList.add(parsedBarcodeItem)
        }
        return parsedList
    }
}