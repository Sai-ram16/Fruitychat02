package com.sairam.fruitychat.screensoffruitychat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sairam.fruitychat.R
import com.sairam.fruitychat.components.ButtonComponent
import com.sairam.fruitychat.components.ClickableLoginTextComponent
import com.sairam.fruitychat.components.DividerTextComponent
import com.sairam.fruitychat.components.HeadingTextComponent
import com.sairam.fruitychat.components.MyTextFieldComponent
import com.sairam.fruitychat.components.PasswordTextFieldComponent
import com.sairam.fruitychat.data.viewmodell
import com.sairam.fruitychat.data.fruitychatlogin.UIeventfruitychat
import com.sairam.fruitychat.navigations.AppRouter
import com.sairam.fruitychat.navigations.Screen
import com.sairam.fruitychat.navigations.SystemBackButtonHandler


@Composable
fun FruitychatLoginScreen(loginViewModel: viewmodell = viewModel()) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFA500))
                .padding(28.dp)
        ) {

            Column( modifier = Modifier.fillMaxSize()
                .background(color = Color(0xFFFFA500))
            ) {
                Image(
                    modifier = Modifier.size(350.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null)
                Spacer(modifier = Modifier.height(0.dp))
                HeadingTextComponent(value = "Login")
                Spacer(modifier = Modifier.height(20.dp))

                MyTextFieldComponent(labelValue = stringResource(id = com.sairam.fruitychat.R.string.email),
                    painterResource(id = com.sairam.fruitychat.R.drawable.message),
                    onTextChanged = { loginViewModel.onEvent(UIeventfruitychat.EmailChanged(it)) },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id =com.sairam.fruitychat. R.string.password),
                    painterResource(id = com.sairam.fruitychat.R.drawable.lock),
                    onTextSelected = {
                        loginViewModel.onEvent(UIeventfruitychat.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(40.dp))

                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(
                    value = stringResource(id = com.sairam.fruitychat.R.string.login),
                    onButtonClicked = {
                       loginViewModel.onEvent(UIeventfruitychat.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    AppRouter.navigateTo(Screen.SignUpScreen)
                })
            }
        }

        if(loginViewModel.loginInProgress.value) {
            CircularProgressIndicator()
        }
    }

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignUpScreen)
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    FruitychatLoginScreen()
}

