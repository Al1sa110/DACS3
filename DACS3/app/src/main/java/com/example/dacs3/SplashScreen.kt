package com.example.dacs3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ShowImage(){
    Image(
        painter = painterResource(id = R.drawable.intro),
        contentDescription = "SplashImage",
    )
}

val textStyle1 = TextStyle(
    fontSize = 25.sp,
    lineHeight = 40.sp
)

val textStyle2 = TextStyle(
    fontSize = 20.sp,
    lineHeight = 30.sp
)

@Composable
fun ShowText1(){
    Text(
        text = "Explore, Connect, Adventure \n Your Own Travel Companion",
        textAlign = TextAlign.Center,
        style = textStyle1,
        modifier = Modifier.padding(vertical = 10.dp),
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Serif,
    )
}

@Composable
fun ShowText2(){
    Text(
        text = "Unlimited Travel Experience",
        textAlign = TextAlign.Center,
        style = textStyle2,
        modifier = Modifier.padding(vertical = 5.dp),
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Serif,
        fontStyle = FontStyle.Italic,
    )
}

@Composable
fun JoinButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate("signup")
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2F4F4F)
        ),
        modifier = Modifier.padding(top = 16.dp)
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Join Now !", Modifier.padding(end = 10.dp))
            Image(
                painterResource(id = R.drawable.arrow),
                contentDescription ="Arrow",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun Ahave(navController: NavController) {
    val text = "Already have account ?"

    ClickableText(
        modifier = Modifier.padding(top = 10.dp),
        text = AnnotatedString(text),
        onClick = {navController.navigate("login")},
        style = TextStyle(color = Color.DarkGray, textDecoration = TextDecoration.Underline, fontWeight = FontWeight.Bold)
    )
}

@Composable
fun ADon(navController: NavController) {
    val text = "Doesn't have account ?"

    ClickableText(
        modifier = Modifier.padding(top = 10.dp),
        text = AnnotatedString(text),
        onClick = {navController.navigate("signup")},
        style = TextStyle(color = Color.DarkGray, textDecoration = TextDecoration.Underline, fontWeight = FontWeight.Bold)
    )
}





