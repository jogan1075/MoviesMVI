package com.jmc.movie_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.jmc.movie_compose.ui.theme.MovieComposeTheme
import com.jmc.navigation.ScreenDestination
import com.jmc.navigation.base.loadMultiNavComposable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        FirebaseApp.initializeApp(this)

        setContent {
            val navController = rememberNavController()
            MovieComposeTheme {
                NavHost(
                    navController = navController,
                    startDestination = ScreenDestination.RegisterScreen.route
                ) {
                    loadMultiNavComposable(navController)
                }

            }
        }
    }
}
