package com.jmc.movie_compose.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.jmc.navigation.ScreenDestination

/**
 * Navigation Graph to control the Alkaa navigation.
 *
 * @param startDestination the start destination of the graph
 */
@Composable
fun NavGraph() {
    val navController = rememberNavController()
//    NavHost(
//        navController = navController,
//        startDestination = ScreenDestination.RegisterScreen.route
//    ) {

//        composable(ScreenDestination.SplashScreen.route) {
//            SplashScreenView(navController = navController)
//        }
//
//        composable(ScreenDestination.LoginScreen.route) {
//            LoginScreenView(navController = navController)
//        }
//        composable(ScreenDestination.RegisterScreen.route) { backStackEntry ->
//            RegisterScreenView(navController = navController)
//        }

//        composable(ScreenDestination.ForgotPasswordScreen.route) {
//            ForgotScreenView(navController = navController)
//        }

//    }
}


//internal data class Actions(val navController: NavHostController, val context: Context) {
//
//    val openTaskDetail: (Long) -> Unit = { taskId ->
//        navController.navigate("${Destinations.TaskDetail}/$taskId")
//    }
//
//    val openAbout: () -> Unit = {
//        navController.navigate(Destinations.About)
//    }
//
//    val openTracker: () -> Unit = {
//        navController.navigate(Destinations.Tracker)
//    }
//
//    val onUpPress: () -> Unit = {
//        navController.navigateUp()
//    }
//}
//
//private const val FEATURE_TRACKER = "tracker"
//
//private const val TRACKER_DEEP_LINK = "app://com.escodro.tracker"
