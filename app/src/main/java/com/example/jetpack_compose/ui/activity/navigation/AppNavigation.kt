package com.example.jetpack_compose.ui.activity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose.ui.activity.auth.ForgetPasswordAuth
import com.example.jetpack_compose.ui.activity.auth.LoginScreen
import com.example.jetpack_compose.ui.activity.auth.MPINAuth
import com.example.jetpack_compose.ui.activity.auth.SignUpAuth
import com.example.jetpack_compose.ui.activity.home.DashboardScreen
import com.example.jetpack_compose.ui.activity.splash.SplashScreen
import com.example.jetpack_compose.utils.Constants

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splashScreen") {
        composable(Constants.splashScreen) { SplashScreen(navController) }
        composable(Constants.loginScreen) { LoginScreen(navController) }
        composable(Constants.dashboardScreen) { DashboardScreen() }
        composable(Constants.signUpScreen) { SignUpAuth(navController) }
        composable(Constants.forgotScreen) { ForgetPasswordAuth(navController) }
        composable(Constants.mpin) { MPINAuth(navController) }
    }
}
