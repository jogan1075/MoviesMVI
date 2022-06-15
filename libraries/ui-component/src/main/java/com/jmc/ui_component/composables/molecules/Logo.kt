package com.jmc.ui_component.composables.molecules

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jmc.ui_component.composables.atoms.LogoImage
import com.jmc.ui_component.composables.atoms.LogoText


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun LogoBlock(modifierCustom: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(color = MaterialTheme.colors.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifierCustom,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogoImage()
            LogoText()
        }
    }
}