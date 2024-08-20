package com.sairam.fruitychat.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sairam.fruitychat.data.fruitychathome.Fruitychathviewmodel
import com.sairam.fruitychat.navigations.AppRouter
import com.sairam.fruitychat.navigations.Screen
import com.sairam.fruitychat.screensoffruitychat.HomeScreen
import com.sairam.fruitychat.screensoffruitychat.Fruitychatregister
import com.sairam.fruitychat.screensoffruitychat.TermsAndConditionsScreen


@Composable
fun FruitsApp(homeViewModel: Fruitychathviewmodel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            AppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = AppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    Fruitychatregister()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    Fruitychatregister()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }
            }
        }

    }
}