package com.jmc.register.domain.repository

import com.jmc.mvi.DataState
import com.jmc.register.domain.model.ResultState
import kotlinx.coroutines.flow.Flow

interface Repository {

   suspend fun registerUser(email: String, password: String): Boolean


}