package com.jmc.androidutils.registry

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.jmc.androidutils.screen.Screen

@Composable
 inline fun <reified T : ScreenProvider> rememberScreen(provider: T): Screen =
    remember(provider) {
        ScreenRegistry.get(provider)
    }

 interface ScreenProvider
