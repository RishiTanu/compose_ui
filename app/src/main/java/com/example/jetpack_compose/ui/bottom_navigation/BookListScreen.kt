package com.example.jetpack_compose.ui.bottom_navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BookListScreen() {

    Box(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colors.background)
    ){
        Text(
            text = "BookList",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colors.primary
        )
    }
}

