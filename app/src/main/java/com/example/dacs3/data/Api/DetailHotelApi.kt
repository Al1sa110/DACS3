package com.example.dacs3.data.Api

import com.example.dacs3.data.model.HotelDto
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailHotelApi {
    @GET("place.php")
    suspend fun getDetailHotel(
        @Query("business_id") business_id: String
    ): HotelDto

    companion object {
        var detailHotelApi: DetailHotelApi? = null

        fun getDetail(): DetailHotelApi {
            if (detailHotelApi == null) {
                val client = OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val request: Request = chain.request().newBuilder()
                            .addHeader("X-RapidAPI-Key", "618a7c10afmsh2148f9275dee7b2p116f00jsnf00742f22c78")
                            .addHeader("X-RapidAPI-Host", "maps-data.p.rapidapi.com")
                            .build()
                        chain.proceed(request)
                    }
                    .build()

                detailHotelApi = Retrofit.Builder()
                    .baseUrl("https://maps-data.p.rapidapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build().create(DetailHotelApi::class.java)
            }
            return detailHotelApi!!
        }
    }
}