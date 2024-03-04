package com.example.jetpack_compose.utils

object Constants {
    const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$"
    const val DATE_PATTERN = "MM/yyyy"
    const val IMAGE_PATH = "image_path"
    val monthList = listOf("January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December")
    val yearList = listOf("2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029",
        "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040")

    const val home = "home"
    const val profile = "profile"
    const val about = "about"

    const val splashScreen = "splashScreen"
    const val loginScreen = "loginScreen"
    const val dashboardScreen = "dashboardScreen"
    const val signUpScreen = "signUpScreen"
    const val forgotScreen = "forgotScreen"
    const val mpin = "mpin"

    const val homeScreen = "homeScreen"
    const val profileScreen = "profileScreen"
    const val chatScreen = "chatScreen"
    const val bookListScreen = "bookListScreen"
}