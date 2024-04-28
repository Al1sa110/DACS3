package com.example.dacs3.data.Api

import com.example.dacs3.data.model.HotelDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HotelApi {
    @GET("searchDestinationOrHotel")
    suspend fun getHotel(
        @Query("query") query: String,
    ): List<HotelDto>

    companion object{
        var hotelApi: HotelApi? = null
        fun getInstance(): HotelApi {
            if (hotelApi == null){
                hotelApi = Retrofit.Builder()
                    .baseUrl("https://sky-scrapper.p.rapidapi.com/api/v1/hotels/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(HotelApi::class.java)
            }
            return hotelApi!!
        }
    }
}