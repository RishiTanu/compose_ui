package com.example.jetpack_compose.ui.activity.home.utils

import com.example.democompose.R
import com.example.jetpack_compose.utils.Constants.about
import com.example.jetpack_compose.utils.Constants.home
import com.example.jetpack_compose.utils.Constants.profile

sealed class NavDrawerItem(var route: String, var icon: Int, var title: String) {
    object Home : NavDrawerItem(home, R.drawable.home, home)
    object Profile : NavDrawerItem(profile, R.drawable.user_profile, profile)
    object About : NavDrawerItem(about, R.drawable.about, about)
}