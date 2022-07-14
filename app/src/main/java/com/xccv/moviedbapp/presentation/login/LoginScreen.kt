package com.xccv.moviedbapp.presentation.login

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xccv.moviedbapp.presentation.login.components.LottieWorkingLoadingView
import com.xccv.moviedbapp.presentation.login.components.HorizontalDottedProgressBar

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    onClickLogin: (email: String, password: String) -> Unit,
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold {

        //TextFields
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var hasError by remember { mutableStateOf(false) }
        var passwordVisualTransformation by remember {
            mutableStateOf<VisualTransformation>(
                PasswordVisualTransformation()
            )
        }
        val passwordInteractionState = remember { MutableInteractionSource() }
        val emailInteractionState = remember { MutableInteractionSource() }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item { Spacer(modifier = Modifier.height(20.dp)) }
            item { LottieWorkingLoadingView(context = LocalContext.current) }
            item {
                Text(
                    text = "Welcome Back",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            item {
                Text(
                    text = "We have missed you, Let's start by Sign In!",
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }


            item {
                OutlinedTextField(
                    value = email,

                    maxLines = 1,
                    isError = hasError,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    label = { Text(text = "Email address") },
                    placeholder = { Text(text = "abc@gmail.com") },
                    onValueChange = {
                        email = it
                    },
                    interactionSource = emailInteractionState,
                )
            }
            item {
                OutlinedTextField(
                    value = password,
                    maxLines = 1,
                    isError = hasError,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "12334444") },
                    onValueChange = {
                        password = it
                    },
                    interactionSource = passwordInteractionState,
                    visualTransformation = passwordVisualTransformation,
                )
            }

            item {
                var loading by remember { mutableStateOf(false) }
                Button(
                    onClick = {
                        if (invalidInput(email.text, password.text)) {
                            hasError = true
                            loading = false
                        } else {
                            loading = true
                            hasError = false
                            onClickLogin.invoke(email.text, password.text)
                        }

                        keyboardController?.hide()

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .height(50.dp)
                        .clip(CircleShape),
                ) {
                    if (loading) {
                        HorizontalDottedProgressBar()
                    } else {
                        Text(text = "Log In")
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(100.dp)) }
        }
    }
}

@SuppressLint("UnusedCrossfadeTargetStateParameter")
@Composable
fun LoginOnboarding(
    loginViewModel: LoginViewModel = hiltViewModel(),
    content: @Composable() () -> Unit
) {
    var loggedIn by remember { mutableStateOf(false) }

    Crossfade(targetState = loggedIn) {
        LoginScreen(
            onClickLogin = loginViewModel::login
        )
    }

    MaterialTheme(
        content = content
    )

}

fun invalidInput(email: String, password: String) =
    email.isBlank() || password.isBlank()
