package com.example.dacs3.data.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dacs3.data.Api.HotelApi
import com.example.dacs3.data.model.Data
import kotlinx.coroutines.launch

class HotelViewModel : ViewModel() {
    var hotelListRes by mutableStateOf<List<Data>>(emptyList())
    var errorMessage by mutableStateOf("")

    fun getHotelList() {
        viewModelScope.launch {
            val hotelApi = HotelApi.getInstance()
            try {
                val hotelDtoList = hotelApi.getHotel("hotel",
                    "20",
                    "us",
                    "en",
                    "51.5072",
                    "0.12",
                    "0",
                    "13"
                )
                hotelListRes = hotelDtoList.data
            } catch (e: Exception) {
                errorMessage = e.message ?: "Unknown error occurred"
            }
        }
    }
}
