package com.example.jetpack_compose.ui.activity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpack_compose.ui.bottom_navigation.BookListScreen
import com.example.jetpack_compose.ui.bottom_navigation.ChatScreen
import com.example.jetpack_compose.ui.bottom_navigation.HomeScreen
import com.example.jetpack_compose.ui.bottom_navigation.ProfileScreen
import com.example.jetpack_compose.utils.Constants.bookListScreen
import com.example.jetpack_compose.utils.Constants.chatScreen
import com.example.jetpack_compose.utils.Constants.homeScreen
import com.example.jetpack_compose.utils.Constants.profileScreen

@Composable
fun BottomNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = homeScreen) {
        composable(homeScreen) { HomeScreen() }
        composable(bookListScreen) { BookListScreen() }
        composable(chatScreen) { ChatScreen() }
        composable(profileScreen) { ProfileScreen() }
    }
}
