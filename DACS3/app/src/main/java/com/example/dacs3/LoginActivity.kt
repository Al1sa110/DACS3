package com.example.dacs3
import androidx.compose.foundation.Image
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
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginContent() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginMessage by remember { mutableStateOf("") }
    var showMessage by remember { mutableStateOf(false) }

    Image(
        painter = painterResource(id = R.drawable.login),
        contentDescription = "Login Image",
        modifier = Modifier.size(200.dp)
    )

    Text(text = "Welcome Back", fontSize = 28.sp, fontWeight = FontWeight.Bold)

    Spacer(modifier = Modifier.height(10.dp))

    Text(text = "Login to your account")

    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = {
            Text(text = "Email address")
        }
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = {
            Text(text = "Password")
        },
        visualTransformation = PasswordVisualTransformation()
    )

    Spacer(modifier = Modifier.height(16.dp))

    if (showMessage) {
        Text(text = loginMessage, color = Color.Red)
        Spacer(modifier = Modifier.height(16.dp))
    }

    Button(
        onClick = {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener{ task ->
                        showMessage = true
                        if (task.isSuccessful){
                            loginMessage = "Login successful"
                        } else {
                            loginMessage = "Incorrect email or password"
                        }
                    }
            }  else {
                showMessage = true
                loginMessage = "Email and password cannot be empty"
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2F4F4F)
        )
    ) {
        Text(text = "Login")
    }
}


