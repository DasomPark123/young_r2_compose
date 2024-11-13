import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductInfoDTO(
    @SerializedName("list")
    @Expose
    val list: List<ProductListItemDTO>,

    @SerializedName("totalCount")
    @Expose
    val totalCount: String,

    @SerializedName("pageNo")
    @Expose
    val pageNo: String,

    @SerializedName("resultCode")
    @Expose
    val resultCode: String,

    @SerializedName("resultMessage")
    @Expose
    val resultMessage: String,

    @SerializedName("numOfRows")
    @Expose
    val numOfRows: String
)