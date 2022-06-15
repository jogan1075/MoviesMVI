package com.jmc.register.domain

import com.jmc.mvi.DataState
import com.jmc.register.domain.model.ResultState
import com.jmc.register.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repository: Repository) {

    fun execute(email: String, password: String): Flow<DataState<Boolean>> = flow {
        emit(DataState.Loading)
        try {
//            val response = repository.registerUser(email, password)
            emit(DataState.Success(true))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}