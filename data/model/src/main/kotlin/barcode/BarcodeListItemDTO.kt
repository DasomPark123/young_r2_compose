package barcode

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BarcodeListItemDTO(
    @SerializedName("CLSBIZ_DT")
    @Expose
    val closedBusinessData : String,

    @SerializedName("SITE_ADDR")
    @Expose
    val address : String,

    @SerializedName("PRDLST_REPORT_NO")
    @Expose
    val productReportNo : String,

    @SerializedName("PRMS_DT")
    @Expose
    val reportDate : String,

    @SerializedName("PRDLST_NM")
    @Expose
    val productName : String,

    @SerializedName("BAR_CD")
    @Expose
    val barcodeNo : String,

    @SerializedName("POG_DAYCNT")
    @Expose
    val expirationDate : String,

    @SerializedName("PRDLST_DCNM")
    @Expose
    val productType : String,

    @SerializedName("BSSH_NM")
    @Expose
    val companyName : String,

    @SerializedName("END_DT")
    @Expose
    val productionStopDate : String,

    @SerializedName("INDUTY_NM")
    @Expose
    val sectors : String
)
