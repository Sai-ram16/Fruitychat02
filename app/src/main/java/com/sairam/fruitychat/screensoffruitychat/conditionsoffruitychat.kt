package com.sairam.fruitychat.screensoffruitychat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sairam.fruitychat.R
//import com.example.myproject.R
import com.sairam.fruitychat.fruitchatcomponents.HeadingTextComponent
import com.sairam.fruitychat.fruitchatcomponents.NormalTextComponent
import com.sairam.fruitychat.Routeplanning.AppRouter
import com.sairam.fruitychat.Routeplanning.Screen
import com.sairam.fruitychat.Routeplanning.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFA500))
        .padding(220.dp)) {

        HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
        }
    NormalTextComponent(value = stringResource(id = R.string.terms_and_conditions_headerdes))

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun TermsAndConditionsScreenPreview(){
    TermsAndConditionsScreen()
}