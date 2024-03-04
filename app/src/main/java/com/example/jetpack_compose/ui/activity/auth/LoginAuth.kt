package com.example.jetpack_compose.ui.activity.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.democompose.R
import com.example.jetpack_compose.utils.Constants.dashboardScreen
import com.example.jetpack_compose.utils.Constants.forgotScreen
import com.example.jetpack_compose.utils.Constants.mpin
import com.example.jetpack_compose.utils.Constants.signUpScreen

@Composable
fun LoginScreen(navController: NavController) {
    // State for username and password
    var mobile by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var checkbox by remember {
        mutableStateOf(false)
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Image(
            painter = painterResource(id = R.drawable.profile_new), // replace with your logo resource ID
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp) // Adjust size accordingly
        )

        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = mobile,
            onValueChange = {
                mobile = it
            },
            label = { Text("Mobile") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkbox,
                    onCheckedChange = {
                        checkbox = !checkbox
                    },
                    colors = CheckboxDefaults.colors(Color.Blue)
                )
                Text("Remember me", color = Color.Gray)
            }
            TextButton(onClick = {
                navController.navigate(forgotScreen)
            }) {
                Text("Forget Password", color = Color.Blue)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate(dashboardScreen)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Login", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))

        TextButton(onClick = {
            navController.navigate(signUpScreen)
        }) {
            Text("Don't have an account yet? Sign up", color = Color.Blue)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = {
            navController.navigate(mpin)
        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("MPIN", color = Color.Green, fontSize = 18.sp)
        }
    }
}