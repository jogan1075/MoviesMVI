package com.jmc.register.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.composable
import com.jmc.navigation.ScreenDestination
import com.jmc.navigation.base.NavComposableModule
import com.jmc.register.ui.RegisterScreenView

val registerNav = NavComposableModule { navHost, navController ->
    navHost.apply {
        composable(ScreenDestination.RegisterScreen.route) {
            RegisterScreenView(
                navController = navController,
                viewModelRegister = hiltViewModel()
            )
        }
    }
}