package com.jmc.register.data.repository

import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface Remote {

    suspend fun registerUser(email: String, password: String): Boolean
}