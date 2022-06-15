package com.jmc.register.data

import com.jmc.register.data.source.DataSourceFactory
import com.jmc.register.domain.model.ResultState
import com.jmc.register.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataRepository @Inject constructor(private val factory: DataSourceFactory) :
    Repository {

//    override suspend fun registerUser(): ResultState {
//        return factory.getRemote().registerUser().map {
//            if (it)
//                ResultState.goToHome
//            else
//                ResultState.goToError(Throwable("error"))
//        }
//    }


    override suspend fun registerUser(email: String, password: String): Boolean {


        return factory.getRemote().registerUser(email, password)
    }


}