package com.sairam.fruitychat.fruitchatdata.fruitychathome

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.sairam.fruitychat.fruitchatdata.routeritem
import com.sairam.fruitychat.Routeplanning.AppRouter
import com.sairam.fruitychat.Routeplanning.Screen

class Fruitychathviewmodel : ViewModel() {

    private val TAG = Fruitychathviewmodel::class.simpleName

    val navigationItemsList = listOf<routeritem>(

        routeritem(
            title = "Fruity chat Homepage",
            icon = Icons.Default.Home,
            description = "Home Screen",
            itemId = "homeScreen"
        ),
        routeritem(
            title = "Favourite Fruits",
            icon = Icons.Default.Favorite,
            description = "Favorite Screen",
            itemId = "favoriteScreen"
        ),
        routeritem(
            title = "Settings",
            icon = Icons.Default.Settings,
            description = "Settings Screen",
            itemId = "settingsScreen"
        ),

    )

    val isUserLoggedIn: MutableLiveData<Boolean> = MutableLiveData()

    fun logout() {

        val firebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.signOut()

        val authStateListener = FirebaseAuth.AuthStateListener {
            if (it.currentUser == null) {
                Log.d(TAG, "Inside sign outsuccess")
                AppRouter.navigateTo(Screen.LoginScreen)
            } else {
                Log.d(TAG, "Inside sign out is not complete")
            }
        }

        firebaseAuth.addAuthStateListener(authStateListener)

    }

    fun checkForActiveSession() {
        if (FirebaseAuth.getInstance().currentUser != null) {
            Log.d(TAG, "Valid session")
            isUserLoggedIn.value = true
        } else {
            Log.d(TAG, "User is not logged in")
            isUserLoggedIn.value = false
        }
    }


    val emailId: MutableLiveData<String> = MutableLiveData()

    fun getUserData() {
        FirebaseAuth.getInstance().currentUser?.also {
            it.email?.also { email ->
                emailId.value = email
            }
        }
    }

}