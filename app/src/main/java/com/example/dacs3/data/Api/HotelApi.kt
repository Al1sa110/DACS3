package com.example.dacs3.data.Api

import com.example.dacs3.data.model.HotelDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HotelApi {
    @GET("searchmaps.php")
    suspend fun getHotel(
        @Query("query") query: String,
        @Query("limit") limit: Int,
        @Query("country") country: String,
        @Query("lang") lang: String,
        @Query("lat") lat: Double,
        @Query("lng") lng: Double,
        @Query("offset") offset: Int,
        @Query("zoom") zoom: Int,
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") apiHost: String
    ): List<HotelDto>

    companion object{
        var hotelApi: HotelApi? = null
        fun getInstance(): HotelApi {
            if (hotelApi == null){
                hotelApi = Retrofit.Builder()
                    .baseUrl("https://maps-data.p.rapidapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(HotelApi::class.java)
            }
            return hotelApi!!
        }
    }
}