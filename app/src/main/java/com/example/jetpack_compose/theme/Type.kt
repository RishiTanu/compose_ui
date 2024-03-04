package com.example.jetpack_compose.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.democompose.R


val DancingScript = FontFamily(
    listOf(
        Font(
            R.font.dancingscript_regular,
            weight = FontWeight.Normal
        ),
        Font(
            R.font.dancingscript_bold,
            weight = FontWeight.Bold
        ),
        Font(
            R.font.dancingscript_medium,
            weight = FontWeight.Medium
        ),
        Font(
            R.font.dancingscript_medium,
            weight = FontWeight.SemiBold
        ),
    )
)
val Typography = androidx.compose.material.Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val SilkscreenFamily = FontFamily(
    listOf(
        Font(
            R.font.silkscreen_regular,
            weight = FontWeight.Normal
        ),
        Font(
            R.font.silkscreen_bold,
            weight = FontWeight.Bold
        )
    )
)

val TekoFamily = FontFamily(
    listOf(
        Font(
            R.font.teko_regular,
            weight = FontWeight.Normal
        ),
        Font(
            R.font.teko_bold,
            weight = FontWeight.Bold
        ),
        Font(
            R.font.teko_semibold,
            weight = FontWeight.SemiBold
        ),
        Font(
            R.font.teko_light,
            weight = FontWeight.Light
        ),
        Font(
            R.font.teko_medium,
            weight = FontWeight.Medium
        ),
    )
)