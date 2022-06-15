package com.jmc.register.ui

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.jmc.register.presentation.RegisterViewModel
import com.jmc.register.presentation.contract.RegisterContract
//import com.jmc.ui_component.composables.atoms.DialogBoxLoading
import com.jmc.ui_component.composables.atoms.ErrorView
import com.jmc.ui_component.composables.atoms.LoadingView
import com.jmc.ui_component.composables.atoms.PrimaryButton
import com.jmc.ui_component.composables.molecules.TopAppBarWithBack
import com.jmc.ui_component.theme.MoviesComposeTheme
import com.jmc.ui_component.theme.PearlLightGray

@Composable
fun RegisterScreenView(navController: NavController, viewModelRegister: RegisterViewModel) {

    when (val screenState = viewModelRegister.uiState.collectAsState().value) {
        is RegisterContract.ScreenState.Idle -> {
            viewModelRegister.setIntent(
                intent = RegisterContract.Intent.DefaultUIntent
            )
        }
        is RegisterContract.ScreenState.Loading -> {
            if (viewModelRegister.isLoadMoreLoading.value) {
//                Surface(
//                    color = Color.Black.copy(alpha = 0.2f),
//                    modifier = Modifier.fillMaxSize()
//                ) {
//                    Dialog(
//                        onDismissRequest = { }
//                    ) {
                        CircularProgressIndicator()
//                    }
//                }
            }
//            DialogBoxLoading(flag = viewModelRegister.isLoadMoreLoading.value)
        }
        is RegisterContract.ScreenState.SideEffect -> {
            SideEffectHandler(
                effectState = screenState.sideEffect, viewModelRegister
            )
        }
        is RegisterContract.ScreenState.Users -> {
            UsersStateHandler(
                userState = screenState.userState,
                navController = navController,
                viewModelRegister
            )
        }

    }

    @Composable
    fun ShowDialog(usersViewModel: RegisterViewModel) {
        val stateLoading = remember { mutableStateOf<Boolean>(false) }
        val coroutineScope = rememberCoroutineScope()



//    ContentWhenNotLoading(onClickLoading = doLoadingForAWhile, stateLoading.value)
    }

}


@Composable
fun SideEffectHandler(
    effectState: RegisterContract.SideEffect,
    viewModelRegister: RegisterViewModel
) {
    when (effectState) {
        is RegisterContract.SideEffect.ShowError -> {
            ErrorView()
        }
        RegisterContract.SideEffect.Loading -> {

//            ShowDialog(viewModelRegister)
//            DialogBoxLoading(flag = viewModelRegister.isLoadMoreLoading.value)
//            Dialog(
//                onDismissRequest = { }
//            ) {
//                CircularProgressIndicator()
//            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UsersStateHandler(
    userState: RegisterContract.UsersState,
    navController: NavController,
    usersViewModel: RegisterViewModel
) {
    when (userState) {
        is RegisterContract.UsersState.Empty,
        is RegisterContract.UsersState.Error -> ErrorView()
        is RegisterContract.UsersState.Loading -> {
//            ShowDialog(usersViewModel)
//            DialogBoxLoading(flag = usersViewModel.isLoadMoreLoading.value)
        }
        is RegisterContract.UsersState.Success -> {
            DefaultPreviewRegister(navController = navController, usersViewModel = usersViewModel)
        }
    }
}



@Composable
private fun ButtonRegister(usersViewModel: RegisterViewModel) {
    PrimaryButton("Register", onClickAction = {
        usersViewModel.setIntent(
            RegisterContract.Intent.PressButtonUIntent(
                "test@test.cl",
                "123456"
            )
        )
    })
}

@ExperimentalFoundationApi
@Composable()
fun DefaultPreviewRegister(navController: NavController, usersViewModel: RegisterViewModel) {
    MoviesComposeTheme(darkTheme = true) {


        Scaffold(topBar = {
            TopAppBarWithBack(
                onBackClick = {
                    /* navController.popBackStack()*/
                },
            )

        }, backgroundColor = MaterialTheme.colors.primary,
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colors.primary)
                        .verticalScroll(rememberScrollState())
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        ImageAvatar()
                        InputFirstName()
                        InputLastName()
                        InputEmail()
                        InputPassword()
                        InputConfirmPassword()
                        ButtonRegister(usersViewModel)
//                        if (usersViewModel.isLoadMoreLoading.value) {
////                            DialogBoxLoading(flag = usersViewModel.isLoadMoreLoading.value)
//
////                            Dialog(
////                                onDismissRequest = { }
////                            ) {
//                                CircularProgressIndicator()
////                            }
//                        }

                    }
                }
            }
        )
    }

}


@Composable
fun DialogBoxLoading(
    cornerRadius: Dp = 16.dp,
    paddingStart: Dp = 56.dp,
    paddingEnd: Dp = 56.dp,
    paddingTop: Dp = 32.dp,
    paddingBottom: Dp = 32.dp,
    progressIndicatorColor: Color = Color(0xFF35898f),
    progressIndicatorSize: Dp = 80.dp,
    flag: Boolean
) {

    Dialog(
        onDismissRequest = {
        }
    ) {
        Surface(
            elevation = 4.dp,
            shape = RoundedCornerShape(cornerRadius)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = paddingStart, end = paddingEnd, top = paddingTop),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                ProgressIndicatorLoading(
                    progressIndicatorSize = progressIndicatorSize,
                    progressIndicatorColor = progressIndicatorColor
                )

                // Gap between progress indicator and text
                Spacer(modifier = Modifier.height(32.dp))

                // Please wait text
                Text(
                    modifier = Modifier
                        .padding(bottom = paddingBottom),
                    text = "Please wait...",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}

@Composable
fun ProgressIndicatorLoading(progressIndicatorSize: Dp, progressIndicatorColor: Color) {

    val infiniteTransition = rememberInfiniteTransition()

    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 600
            }
        )
    )

    CircularProgressIndicator(
        progress = 1f,
        modifier = Modifier
            .size(progressIndicatorSize)
            .rotate(angle)
            .border(
                12.dp,
                brush = Brush.sweepGradient(
                    listOf(
                        Color.White, // add background color first
                        progressIndicatorColor.copy(alpha = 0.1f),
                        progressIndicatorColor
                    )
                ),
                shape = CircleShape
            ),
        strokeWidth = 1.dp,
        color = Color.White // Set background color
    )
}

@Composable
fun ButtonClick(
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        onClick = {
            onButtonClick()
        }) {
        Text(
            text = buttonText,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}


@Composable
private fun InputFirstName() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "First Name",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(
                top = 10.dp,
                bottom = 10.dp
            )
        )
    }


    var firstName by remember { mutableStateOf("") }

    TextField(
        value = firstName,
        leadingIcon = {
            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                    Canvas(
                        modifier = Modifier
                            .height(24.dp)
                            .padding(start = 10.dp)
                    ) {
                        drawLine(
                            color = PearlLightGray,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 2.0F
                        )
                    }
                }
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "First Name") },
        shape = RoundedCornerShape(8.dp),
        onValueChange = {
            firstName = it
        }
    )

}

@Composable
private fun InputLastName() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Last Name",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(
                top = 10.dp,
                bottom = 10.dp
            )
        )
    }


    var lastName by remember { mutableStateOf("") }

    TextField(
        value = lastName,
        leadingIcon = {
            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                    Canvas(
                        modifier = Modifier
                            .height(24.dp)
                            .padding(start = 10.dp)
                    ) {
                        drawLine(
                            color = PearlLightGray,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 2.0F
                        )
                    }
                }
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "Last Name") },
        shape = RoundedCornerShape(8.dp),
        onValueChange = {
            lastName = it
        }
    )

}

@Composable
private fun InputPassword() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Password",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(
                top = 10.dp,
                bottom = 10.dp
            )
        )
    }


    var password by remember { mutableStateOf("") }

    TextField(
        value = password,
        leadingIcon = {
            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                    Canvas(
                        modifier = Modifier
                            .height(24.dp)
                            .padding(start = 10.dp)
                    ) {
                        drawLine(
                            color = PearlLightGray,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 2.0F
                        )
                    }
                }
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        label = { Text(text = "Password") },
        shape = RoundedCornerShape(8.dp),
        onValueChange = {
            password = it
        }
    )
}

@Composable
private fun InputConfirmPassword() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Confirm Password",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(
                top = 10.dp,
                bottom = 10.dp
            )
        )
    }

    var confirmPassword by remember { mutableStateOf("") }

    TextField(
        value = confirmPassword,
        leadingIcon = {
            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                    Canvas(
                        modifier = Modifier
                            .height(24.dp)
                            .padding(start = 10.dp)
                    ) {
                        drawLine(
                            color = PearlLightGray,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 2.0F
                        )
                    }
                }
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        label = { Text(text = "Confirm Password") },
        shape = RoundedCornerShape(8.dp),
        onValueChange = {
            confirmPassword = it
        }
    )
}


@Composable
private fun InputEmail() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Email Address",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(
                top = 10.dp,
                bottom = 10.dp
            )
        )
    }

    var email by remember { mutableStateOf("") }

    TextField(
        value = email,
        leadingIcon = {
            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                    Canvas(
                        modifier = Modifier
                            .height(24.dp)
                            .padding(start = 10.dp)
                    ) {
                        drawLine(
                            color = PearlLightGray,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 2.0F
                        )
                    }
                }
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        label = { Text(text = "Email address") },
        shape = RoundedCornerShape(8.dp),
        onValueChange = {
            email = it
        }
    )

}


@Composable
private fun ImageAvatar() {
    Row(modifier = Modifier.padding(top = 32.dp)) {
        Image(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
            modifier = Modifier
                .size(160.dp)
                .padding(32.dp)
                .clip(CircleShape)
                .border(4.dp, MaterialTheme.colors.secondary, CircleShape),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
    }

}

