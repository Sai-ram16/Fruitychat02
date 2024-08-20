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

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere","inside_NavigationItemClicked")
                    Log.d("ComingHere","${it.itemId} ${it.title}")
                })
        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 420.dp)
                        .requiredHeight(height = 760.dp)
                        .background(color = Color(0xFFFFA500))

                ) {






                    val localContext = LocalContext.current
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 13.dp,
                                y = 181.dp
                            )
                            .requiredWidth(width = 146.dp)
                            .requiredHeight(height = 209.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = "",
                            modifier = Modifier
                                .requiredWidth(width = 157.dp)
                                .requiredHeight(height = 150.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                        )
                        val localContext = LocalContext.current


                    }

                    Text(
                        text = "Custard Apple",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 62.dp, y = 539.dp)
                    )
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 220.dp, y = 172.dp)
                            .requiredWidth(width = 146.dp)
                            .requiredHeight(height = 211.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.grapes),
                            contentDescription = "",
                            modifier = Modifier
                                .requiredWidth(width = 157.dp)
                                .requiredHeight(height = 156.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                        )

                    }



                    Image(
                        painter = painterResource(id = R.drawable.banner),
                        contentDescription = "",
                        modifier = Modifier
                            .requiredWidth(width = 470.dp) // Adjust width as needed
                            .requiredHeight(height = 175.dp) // Adjust height as needed
                            .clip(shape = RoundedCornerShape(15.dp)
                            )
                    )
























                }

            }
        }
    }





}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}