package product

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductListItem(
    var productId : String = "알수없음",
    var product : String = "알수없음",
    var seller : String = "알수없음",
    var imageUrl : String = "알수없음",
    var totalContent : String = "알수없음",
    var calorie : String = "-",
    var carbohydrate : String = "-",
    var sugars : String = "-",
    var protein : String = "-",
    var fat : String = "-",
    var saturatedFat : String = "-",
    var transFat : String = "-",
    var cholesterol : String = "-",
    var salt : String = "-",
    var rawMtr : String = "-"
): Parcelable
