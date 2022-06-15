package com.jmc.movie_compose

import android.app.Application
import com.google.firebase.FirebaseApp
import com.jmc.navigation.base.multiNavigationModule
import com.jmc.register.navigation.registerNav
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
@Module
@InstallIn(SingletonComponent::class)
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
        multiNavigationModule(registerNav)
    }

}