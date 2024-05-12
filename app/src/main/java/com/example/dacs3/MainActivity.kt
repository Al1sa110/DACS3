package com.example.dacs3

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dacs3.data.UI.HotelDetailItem
import com.example.dacs3.data.UI.HotelItem
import com.example.dacs3.data.model.Data
import com.example.dacs3.data.model.HotelDto
import com.example.dacs3.data.viewModel.DetailHotelViewModel
import com.example.dacs3.data.viewModel.HotelViewModel
import com.example.dacs3.ui.theme.DACS3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DACS3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavigation(context = this)

                }
            }
        }
    }
}

@Composable
fun MainNavigation(context: Context) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("signup") { SignupScreen(navController,context) }
        composable("login") { LoginScreen(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        )
    {
        ShowImage()
        ShowText1()
        ShowText2()
        JoinButton(navController)
        Ahave(navController)
    }

}


@Composable
fun SignupScreen(navController: NavController,context: Context){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    )
    {
        SignupContent(navController,context)
        Ahave(navController)
    }
}

@Composable
fun LoginScreen(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    )
    {
        LoginContent()
        ADon(navController)
    }
}

@Composable
fun HotelList(hotelList: List<Data>){
    LazyColumn {
        itemsIndexed(items = hotelList){ index, item ->
            HotelItem(hotel = HotelDto(listOf(item)))
        }
    }
}

@Composable
fun HotelDetail(hotelDetail: List<Data>){
    LazyColumn {
        itemsIndexed(items = hotelDetail){ index, item ->
            HotelDetailItem(hotel = HotelDto(listOf(item)))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DACS3Theme {
        HomeScreen(rememberNavController())
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewSignupScreen() {
//    SignupScreen(rememberNavController())
//}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun PreviewHotel(hotelViewModel: HotelViewModel = HotelViewModel()) {
    if (hotelViewModel.hotelListRes.isEmpty()) {
        hotelViewModel.getHotelList()
    }
    hotelViewModel.hotelListRes.let { hotelList ->
        HotelList(hotelList = hotelList)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailHotel(detailHotelViewModel: DetailHotelViewModel = DetailHotelViewModel()) {
    if (detailHotelViewModel.hotelDetailRes.isEmpty()) {
        detailHotelViewModel.getHotelDetail()
    }
    detailHotelViewModel.hotelDetailRes.let { hotelDetail ->
        HotelDetail(hotelDetail = hotelDetail)
    }
}





