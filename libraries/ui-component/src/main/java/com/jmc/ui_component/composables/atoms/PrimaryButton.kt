package com.jmc.ui_component.composables.atoms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(text: String, onClickAction: () -> Unit) {
    Button(
        onClick = onClickAction,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 30.dp,
                start = 32.dp, end = 32.dp
            ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.button,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
    }
}