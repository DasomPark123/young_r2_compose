import com.google.gson.annotations.SerializedName
import android.os.Parcelable

data class ProductListItemDTO(
    @SerializedName("allergy")
    val allergy: String,

    @SerializedName("barcode")
    val barcode: String,

    @SerializedName("capacity")
    val capacity: String,

    @SerializedName("imgurl1")
    val imgurl1: String,

    @SerializedName("imgurl2")
    val imgurl2: String,

    @SerializedName("manufacture")
    val manufacture: String,

    @SerializedName("nutrient")
    val nutrient: String,

    @SerializedName("prdkind")
    val prdkind: String,

    @SerializedName("prdkindstate")
    val prdkindstate: String,

    @SerializedName("prdlstNm")
    val prdlstNm: String,

    @SerializedName("prdlstReportNo")
    val prdlstReportNo: String,

    @SerializedName("productGb")
    val productGb: String,

    @SerializedName("rawmtrl")
    val rawmtrl: String,

    @SerializedName("rnum")
    val rnum: String,

    @SerializedName("seller")
    val seller: String
)
