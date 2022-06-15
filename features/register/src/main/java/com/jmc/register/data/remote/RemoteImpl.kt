package com.jmc.register.data.remote

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.jmc.register.data.repository.Remote
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RemoteImpl @Inject constructor(private val authInstance: FirebaseAuth) : Remote {

    override suspend fun registerUser(email: String, password: String): Boolean {

        var response: Boolean = false
        val await =
            authInstance.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                response = it.isSuccessful
            }.await()

        return response
//        return authInstance.currentUser ?: throw FirebaseAuthException("", "")
    }
}