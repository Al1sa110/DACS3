package com.example.dacs3.data.UI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dacs3.data.model.HotelDto

@Composable
fun HotelItem(hotel: HotelDto) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Surface {
            Column(
                Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = hotel.data.firstOrNull()?.name ?: "Unknown",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Rating: ${hotel.data.firstOrNull()?.rating ?: "N/A"}",
                    fontWeight = FontWeight.Normal,
                    color = Color.Red,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Address: ${truncateAddress(hotel.data.firstOrNull()?.full_address)}",
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2F4F4F)
                    ),
                    modifier = Modifier.align(Alignment.End)

                ) {
                    Text("More details")
                }
            }
        }
    }
}

@Composable
fun truncateAddress(address: String?): String {
    val maxLength = 100
    return if (address != null && address.length > maxLength) {
        address.substring(0, maxLength) + "..."
    } else {
        address ?: "N/A"
    }
}
