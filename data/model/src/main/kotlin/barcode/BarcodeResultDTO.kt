package barcode

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BarcodeResultDTO(
    @SerializedName("MSG")
    @Expose
    val msg : String,

    @SerializedName("CODE")
    @Expose
    val code : String
)
