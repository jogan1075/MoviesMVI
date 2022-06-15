package com.jmc.register.domain.model

sealed class ResultState{

    data class goToError(val error: Throwable) : ResultState()

    object goToHome : ResultState()
}
