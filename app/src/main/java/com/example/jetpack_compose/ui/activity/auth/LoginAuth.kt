package com.example.jetpack_compose.ui.activity.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
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
fun LoginScreen(
    navController: NavController,
    focusManager: FocusManager = LocalFocusManager.current,
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
) {
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
            onValueChange = {newValue ->
                // Check if the new value is less than or equal to 10 characters and only contains digits
                if (newValue.length <= 10 && newValue.all { it.isDigit() }) {
                    mobile = newValue
                }
            },
            label = {
                Text("Mobile")
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
                keyboardController?.hide()
            }),
            placeholder = { Text(text = "Enter your mobile no") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "mobile")
            },
            trailingIcon = {
                Icon(Icons.Default.Clear,
                    contentDescription = "clear text",
                    modifier = Modifier.clickable {

                    })
            },
            shape = RoundedCornerShape(10.dp),
            isError = false,
            maxLines = 1,
            singleLine = true
        )

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {newValue ->
                // Check if the new value is less than or equal to 10 characters and only contains digits
                if (newValue.length <= 5 && newValue.all { it.isDigit() }) {
                    password = newValue
                }
            },
            label = {
                Text("Password")
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
                keyboardController?.hide()
            }),
            placeholder = { Text(text = "Enter your password") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Password, contentDescription = "password")
            },
            trailingIcon = {
                Icon(Icons.Default.Clear,
                    contentDescription = "clear text",
                    modifier = Modifier.clickable {
                    })
            },
            shape = RoundedCornerShape(10.dp),
            isError = false,
            maxLines = 1,
            singleLine = true,

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