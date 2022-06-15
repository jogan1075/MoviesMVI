package com.jmc.ui_component.composables.atoms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalFoundationApi
@Preview(showBackground = true,backgroundColor = 0xFFFFFFFF)
@Composable
fun LogoText() {

//    LazyVerticalGrid(cells = GridCells.Fixed(4), modifier = Modifier.wrapContentWidth()) {
//        this.items("PHOTOPLAY".toCharArray().toList()) { item ->
            Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "PHOTOPLAY",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.secondary,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
            }
//        }
//    }


}