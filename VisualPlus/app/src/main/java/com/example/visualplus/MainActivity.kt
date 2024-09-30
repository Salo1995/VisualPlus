package com.example.visualplus

import com.example.visualplus.LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    LoginScreen(
                        onLoginClick = { /* Implementa la lógica de inicio de sesión */ },
                        onRegisterClick = { /* Implementa la lógica de registro */ },
                        onRecoverClick = { /* Implementa la lógica de recuperación de contraseña */ }
                    )
                }
            }
        }
    }
}
