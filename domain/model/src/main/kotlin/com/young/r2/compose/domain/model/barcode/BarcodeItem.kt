package com.young.r2.compose.domain.model.barcode

data class BarcodeItem(
    var closedBusinessData : String = "",
    var address : String = "",
    var productReportNo : String = "",
    var reportDate : String = "",
    var productName : String = "",
    var barcodeNo : String = "",
    var expirationDate : String = "",
    var productType : String = "",
    var companyName : String = "",
    var productionStopDate : String = "",
    var sectors : String = ""
)
