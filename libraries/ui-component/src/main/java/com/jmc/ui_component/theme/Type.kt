package com.jmc.ui_component.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jmc.ui_component.R

val Gotham = FontFamily(
    Font(R.font.gotham_bold, FontWeight.Bold),
    Font(R.font.gotham_medium, FontWeight.Medium),
    Font(R.font.gotham_book, FontWeight.Normal),
    Font(R.font.gotham_light, FontWeight.Light),
)

val Typography = Typography(
    h4 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 27.sp
    ),
    h6 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Light,
        fontSize = 20.sp
    ),
    button = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp
    ),
    body2 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp
    )
)