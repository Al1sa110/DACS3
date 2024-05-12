package com.example.dacs3
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun SignupContent(navController: NavController,context: Context) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var ErrorMessage by remember { mutableStateOf("") }
    var showMessage by remember { mutableStateOf(false) }
    var showMessageEmail by remember { mutableStateOf(false) }
    var errorPasswordCondition by remember { mutableStateOf(false) }
    var auth: FirebaseAuth
// ...
// Initialize Firebase Auth
    auth = Firebase.auth

    Image(
        painter = painterResource(id = R.drawable.signup),
        contentDescription = "Signup Image",
        modifier = Modifier.size(200.dp)
    )

    Text(text = "Nice To Meet You", fontSize = 28.sp, fontWeight = FontWeight.Bold)

    Spacer(modifier = Modifier.height(10.dp))

    Text(text = "Sign up your account")

    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(
        value = email,
        onValueChange = { email = it
            if(email.isNotEmpty()){
                showMessageEmail=false
            } },
        isError = showMessageEmail,
        label = {
            Text(text = "Email address")
        }
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = password,
        isError = showMessage,
        onValueChange = { password = it
            if(password.length < 6){
                showMessage = true
                ErrorMessage="Password must be at least 6 characters"
            } else {showMessage  = false} },
        label = {
            Text(text = "Password")
        },
        visualTransformation = PasswordVisualTransformation()
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = confirmPassword,
        isError = showMessage,
        onValueChange = { confirmPassword = it },
        label = {
            Text(text = "Confirm Password")
        },
        visualTransformation = PasswordVisualTransformation()
    )
    Spacer(modifier = Modifier.height(16.dp))

    if (showMessage) {
        Text(text = ErrorMessage, color = Color.Red)
        Spacer(modifier = Modifier.height(16.dp))
    }

    Button(
        onClick = {
            if (password.isNotEmpty() && confirmPassword.isNotEmpty() && email.isNotEmpty()) {
                if (password == confirmPassword) {
                    auth.createUserWithEmailAndPassword(email, password)
                    navController.navigate("login")
                    Toast.makeText(context, "Account Created", Toast.LENGTH_SHORT).show()
                } else {
                    showMessage = true
                    ErrorMessage = "Passwords do not match"
                }
            } else {
                showMessage = true
                showMessageEmail = true
                ErrorMessage = "Please fill all the fields"
            }

        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2F4F4F)
        )
    ) {
        Text(text = "Sign Up")
    }

}




