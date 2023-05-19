package com.example.jetpackcomposeandroidmaterial3.ui.fragments

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.jetpackcomposeandroidmaterial3.utils.Fragments
import com.example.jetpackcomposeandroidmaterial3.viewmodel.HomeViewModel
import com.example.jetpackcomposeandroidmaterial3.viewmodel.LoginViewModel

@Composable
fun LoginFragment(context: Context ,navController : NavController) {

    val loginViewModel = viewModel<LoginViewModel>()

    var email by remember {
        mutableStateOf("Atif")
    }

    var password by remember {
        mutableStateOf("123")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(
            text = "Login Here",
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
            color = Color.Green,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(text = "Enter Your Name")
                    },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)

        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    text = "Enter Password",
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.W400,
                    color = Color.Green
                )
            },
            leadingIcon = {
                Icon(Icons.Default.ThumbUp, contentDescription = "icon")
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

        )




        OutlinedButton(
            onClick = { logged(email, password, context,navController) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {
            Text(
                text = "Login",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                color = Color.Green
            )
        }


    }

}

fun logged(email: String, password: String, context: Context,navController : NavController) {

    if (email == "Atif" && password == "123") {
        Toast.makeText(context, "Logged in SuccessFully ", Toast.LENGTH_SHORT).show()
        navController.navigate(Fragments.HomeFragment.route)
    } else {
        Toast.makeText(context, "Logged Failed ", Toast.LENGTH_SHORT).show()
    }


}





