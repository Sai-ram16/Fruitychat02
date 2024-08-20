package com.sairam.fruitychat.screensoffruitychat

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sairam.fruitychat.R
import com.sairam.fruitychat.DetailsPageActivity

//import com.example.project.R
import com.sairam.fruitychat.UserProfileActivity
import com.sairam.fruitychat.fruitchatcomponents.AppToolbar
import com.sairam.fruitychat.fruitchatcomponents.NavigationDrawerBody
import com.sairam.fruitychat.fruitchatcomponents.NavigationDrawerHeader

import com.sairam.fruitychat.fruitchatdata.fruitychathome.Fruitychathviewmodel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: Fruitychathviewmodel = viewModel()) {



}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}