package barcode

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BarcodeInfoDTO(
    @SerializedName("total_count")
    @Expose
    val totalCount : String,

    @SerializedName("row")
    @Expose
    val row : List<BarcodeListItemDTO>,

    @SerializedName("RESULT")
    @Expose
    val result : BarcodeResultDTO
)
