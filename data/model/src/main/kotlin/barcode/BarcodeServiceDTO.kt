package barcode

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BarcodeServiceDTO(
    @SerializedName("C005")
    @Expose
    val COO5 : BarcodeInfoDTO
)
