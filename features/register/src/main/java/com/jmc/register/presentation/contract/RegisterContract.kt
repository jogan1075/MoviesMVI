package com.jmc.register.presentation.contract

import com.jmc.mvi.UiIntent
import com.jmc.mvi.UiState
import kotlinx.coroutines.flow.MutableStateFlow

class RegisterContract {

    sealed class Intent : UiIntent {
        object DefaultUIntent : Intent()
        data class PressButtonUIntent(
            val email: String, val password: String
        ) : Intent()
    }

    sealed class ScreenState : UiState {
        object Idle : ScreenState()
        object Loading : ScreenState()
        object Success : ScreenState()
        data class Users(val userState: UsersState) : ScreenState()
        data class SideEffect(val sideEffect: RegisterContract.SideEffect) : ScreenState()
    }


    sealed class UsersState {
        object Loading : UsersState()
        object Success : UsersState()

        //data class SuccessPaging(val users: MutableStateFlow<PagingData<User>>) : UsersState()
        data class Error(val errorMessage: String?) : UsersState()
        data class Empty(val emptyMessage: String?) : UsersState()
    }

    sealed class SideEffect {
        object Loading : SideEffect()
        data class ShowError(val message: String?) : SideEffect()
    }
}