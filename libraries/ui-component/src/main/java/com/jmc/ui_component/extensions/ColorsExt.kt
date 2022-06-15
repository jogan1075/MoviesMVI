package com.jmc.ui_component.extensions

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.jmc.ui_component.theme.BlackBrown
import com.jmc.ui_component.theme.WetAsphalt

val Colors.textField: Color
    @Composable get() = if (isLight) Color.White else BlackBrown

val Colors.textFieldOnSurface: Color
    @Composable get() = if (isLight) WetAsphalt else Color.White