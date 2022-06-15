package com.jmc.ui_component.composables.atoms

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.jmc.ui_component.R

@Preview(showBackground = true)
@Composable
fun LogoImage(){

    Image(painter  = painterResource(id = R.drawable.ic_logo ) , contentDescription = null )
}
