package com.example.dacs3.data.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dacs3.data.Api.HotelApi
import com.example.dacs3.data.model.HotelDto
import kotlinx.coroutines.launch

class HotelViewModel: ViewModel() {
    var hotelListRes: List<HotelDto> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getHotelList(){
        viewModelScope.launch {
            val hotelApi = HotelApi.getInstance()
            try {
                val hotelList = hotelApi.getHotel( "new")
                hotelListRes = hotelList
            }
            catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}