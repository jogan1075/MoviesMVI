package com.jmc.navigation

import com.jmc.androidutils.registry.ScreenProvider

/*
sealed class ScreenDestination(val route: String) {
    object SplashScreen : ScreenDestination("splash_screen")
    object LoginScreen : ScreenDestination("login_screen")
    object RegisterScreen : ScreenDestination("register_screen")
    object ForgotPasswordScreenDestination : ScreenDestination("forgot_screen")

//    object HomeScreen : Screen("home_screen")
//    object PopularListScreen : Screen("popular_list_screen")
//    object DetailsScreen : Screen("details_screen/{params}") {
//        fun addArgument(params: String) = "details_screen/$params"
//    }
//
//    object AddToCartScreen : Screen("add_to_cart_screen")
//

}
*/



sealed class ScreenDestination(val route: String)  {
    object SplashScreen : ScreenDestination("splash_screen")
    object LoginScreen : ScreenDestination("login_screen")
    object RegisterScreen : ScreenDestination("register_screen")
    object ForgotPasswordScreen : ScreenDestination("forgot_screen")


    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { args ->
                append("/$args")
            }
        }
    }

//    object HomeScreen : Screen("home_screen")
//    object PopularListScreen : Screen("popular_list_screen")
//    object DetailsScreen : Screen("details_screen/{params}") {
//        fun addArgument(params: String) = "details_screen/$params"
//    }
//
//    object AddToCartScreen : Screen("add_to_cart_screen")
//

}