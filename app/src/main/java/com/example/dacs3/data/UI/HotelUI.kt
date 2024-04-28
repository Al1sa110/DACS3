package com.example.dacs3.data.UI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dacs3.data.model.HotelDto

@Composable
fun HotelItem(hotel: HotelDto){
    Card(modifier = Modifier
        .padding(8.dp, 4.dp)
        .fillMaxWidth()
        .height(110.dp), shape = RoundedCornerShape(8.dp)
    ){
        Surface() {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()) {
                Column (
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(text = hotel.hierarchy, color = Color.Red, fontWeight = FontWeight.Bold)
                    Text(text = hotel.location, color = Color.Red)
                    Text(text = hotel.score, color = Color.Red)
                    Text(text = hotel.entityName, color = Color.Red)
                    Text(text = hotel.entityId, color = Color.Red)
                    Text(text = hotel.entityType, color = Color.Red)
                    Text(text = hotel.suggestItem, color = Color.Red)
                    Text(text = hotel.pois, color = Color.Red)
                }
            }
        }
    }

}