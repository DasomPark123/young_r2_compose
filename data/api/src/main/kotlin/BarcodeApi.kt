import barcode.BarcodeServiceDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface BarcodeApi {
    @GET("/api/{serviceKey}/C005/{returnType}/1/1/BAR_CD={barcodeNo}")
    suspend fun getProductByBarcode(
        @Path("serviceKey") serviceKey: String = Key.PRODUCT_BARCODE_KEY,
        @Path("returnType") returnType: String = "json",
        @Path("barcodeNo") barcodeNum: String
    ): retrofit2.Response<BarcodeServiceDTO>
}