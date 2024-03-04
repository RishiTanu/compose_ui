package com.example.jetpack_compose.ui.activity.home.utils

import androidx.annotation.DrawableRes
import com.example.democompose.R
import com.example.jetpack_compose.utils.Constants.bookListScreen
import com.example.jetpack_compose.utils.Constants.chatScreen
import com.example.jetpack_compose.utils.Constants.homeScreen
import com.example.jetpack_compose.utils.Constants.profileScreen

sealed class BottomNavScreen(val route: String, val title: String, @DrawableRes val icon: Int) {
    object HomeScreen : BottomNavScreen(
        route = homeScreen,
        title = "Home",
        icon = R.drawable.ic_home
    )

    object BookListScreen : BottomNavScreen(
        route = bookListScreen,
        title = "BookList",
        icon = R.drawable.ic_book
    )

    object ChatScreen : BottomNavScreen(
        route = chatScreen,
        title = "Chat",
        icon = R.drawable.ic_chat
    )

    object ProfileScreen :
        BottomNavScreen(
            route = profileScreen,
            title = "Profile",
            icon = R.drawable.ic_profile
        )
}