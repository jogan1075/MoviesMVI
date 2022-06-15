package com.jmc.register.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.jmc.mvi.BaseViewModel
import com.jmc.mvi.DataState
import com.jmc.register.domain.RegisterUseCase
import com.jmc.register.domain.model.ResultState
import com.jmc.register.presentation.contract.RegisterContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val userUseCase: RegisterUseCase) :
    BaseViewModel<RegisterContract.Intent, RegisterContract.ScreenState>() {

    //    private val _users = MutableStateFlow<MutableList<User>>(ArrayList())
    var isLoadMoreLoading = mutableStateOf(false)


    override fun createInitialState(): RegisterContract.ScreenState {
        return RegisterContract.ScreenState.Idle
    }

    override fun handleIntent(intent: RegisterContract.Intent) {
        when (intent) {
            is RegisterContract.Intent.PressButtonUIntent -> registerUsers(
                intent.email,
                intent.password
            )
            RegisterContract.Intent.DefaultUIntent -> defaultScreen()
        }
    }

    private fun defaultScreen() {
        setState {
            RegisterContract.ScreenState.Users(userState = RegisterContract.UsersState.Success)

        }
    }

    private fun registerUsers(email: String, password: String) {

        userUseCase.execute(email, password).onEach {
            when (it) {
                is DataState.Error -> {
                    setState {
                        RegisterContract.ScreenState.SideEffect(
                            RegisterContract.SideEffect.ShowError("")
                        )
                    }
                }
                is DataState.Loading -> {
                    setState {
                        isLoadMoreLoading.value = true
//                        RegisterContract.ScreenState.SideEffect(
//                            RegisterContract.SideEffect.Loading
//                        )
                        RegisterContract.ScreenState.Loading
                    }
                }
                is DataState.Success -> {
                    if (it.data) {
//                        isLoadMoreLoading.value = false
//                        RegisterContract.ScreenState.SideEffect(
//                            RegisterContract.SideEffect.Loading
//                        )
                    }
                }
            }
        }.launchIn(viewModelScope)

//        userUseCase.onEach {
//            when (it) {
//                is DataState.Error -> {
//                    if (_users.value.isEmpty()) {
//                        setState {
//                            RegisterContract.ScreenState.SideEffect(
//                                RegisterContract.SideEffect.ShowError("")
//                            )
//                        }
//                    }
//                }
//
//                is DataState.Loading -> {
//                    if (_users.value.isEmpty()) {
//                        setState {
//                            RegisterContract.ScreenState.Users(
//                                RegisterContract.UsersState.Loading
//                            )
//                        }
//                    }
//                }
//                is DataState.Success -> {
//                    if (!it.data.isNullOrEmpty()) {
//                        _users.value.addAll(it.data)
//                        isLoadMoreLoading.value = false
//                        setState {
//                            RegisterContract.ScreenState.Users(
//                                RegisterContract.UsersState.Success(_users)
//                            )
//                        }
//                    } else {
//                        if (_users.value.isEmpty()) {
//                            setState {
//                                RegisterContract.ScreenState.Users(
//                                    RegisterContract.UsersState.Empty("Ops...List is Empty")
//                                )
//                            }
//                        }
//                    }
//                }
//            }
//        }.launchIn(viewModelScope)
    }

}