package com.sairam.fruitychat.data

data class UIstatelogin(
    var email  :String = "",
    var password  :String = "",

    var emailError :Boolean = false,
    var passwordError : Boolean = false

)
