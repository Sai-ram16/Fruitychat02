package com.sairam.fruitychat.fruitchatdata.fruitychatlogin

sealed class UIeventfruitychat{

    data class EmailChanged(val email:String): UIeventfruitychat()
    data class PasswordChanged(val password: String) : UIeventfruitychat()

    object LoginButtonClicked : UIeventfruitychat()
}
