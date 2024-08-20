package com.sairam.fruitychat.fruitchatdata

data class UIstatelogin(
    var email  :String = "",
    var password  :String = "",

    var emailError :Boolean = false,
    var passwordError : Boolean = false

)
