import product.ProductInfoDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {
    @GET("/B553748/CertImgListService/getCertImgListService")
    suspend fun getProductInfoByProductName(
        @Query("ServiceKey") serviceKey: String = Key.PRODUCT_INFO_KEY_DECODING,
        @Query("prdlstNm") prdlstNm: String,
        @Query("pageNo") pageNo: String = "1",
        @Query("numberOfRows") numberOfRows: String = "1",
        @Query("returnType") returnType: String = "json"
    ): retrofit2.Response<ProductInfoDTO>

    @GET("/B553748/CertImgListService/getCertImgListService")
    suspend fun getProductInfoByProductReportNo(
        @Query("ServiceKey") serviceKey: String = Key.PRODUCT_INFO_KEY_DECODING,
        @Query("prdlstReportNo") prdlstReportNo: String,
        @Query("pageNo") pageNo: String = "1",
        @Query("numberOfRows") numberOfRows: String = "1",
        @Query("returnType") returnType: String = "json"
    ): retrofit2.Response<ProductInfoDTO>
}