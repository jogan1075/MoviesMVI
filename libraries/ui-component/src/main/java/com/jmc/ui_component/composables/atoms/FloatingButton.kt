package com.jmc.ui_component.composables.atoms


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.jmc.ui_component.theme.DarkTangerine
import com.jmc.ui_component.theme.ShinyOrange

@Composable
fun FloatingButton(@DrawableRes imageRes: Int, onClick: () -> Unit = {}, color: Color = Color.Unspecified) =
    FloatingButton(
        onClick = onClick
    ) {
        Image(
            painter = rememberCoilPainter(request = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(28.dp)
                .padding(end = 2.dp),
            colorFilter = ColorFilter.tint(color)
        )
    }

@Composable
private fun FloatingButton(onClick: () -> Unit = {}, content: @Composable () -> Unit) =
    FloatingActionButton(
        onClick = onClick,
        backgroundColor = Color.Transparent,
        modifier = Modifier.size(48.dp),
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp,
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(ShinyOrange, DarkTangerine)
                    )
                )
        ) {
            content()
        }
    }