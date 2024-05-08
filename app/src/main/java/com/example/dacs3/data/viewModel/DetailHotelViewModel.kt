package com.example.dacs3.data.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dacs3.data.Api.DetailHotelApi
import com.example.dacs3.data.Api.HotelApi
import com.example.dacs3.data.model.Data
import kotlinx.coroutines.launch

class DetailHotelViewModel : ViewModel() {
    var hotelDetailRes by mutableStateOf<List<Data>>(emptyList())
    var errorMessage by mutableStateOf("")

    fun getHotelDetail() {
        viewModelScope.launch {
            val detailHotelApi = DetailHotelApi.getDetail()
            try {
                val hotelDetail = detailHotelApi.getDetailHotel(
                    "0x47f4eaf09c2bf893:0x903d00d81f0eb813"
                )
                hotelDetailRes = hotelDetail.data
            } catch (e: Exception) {
                errorMessage = e.message ?: "Unknown error occurred"
            }
        }
    }
}
