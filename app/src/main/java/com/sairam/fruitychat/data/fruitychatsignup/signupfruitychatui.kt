package  com.sairam.fruitychat.data.fruitychatsignup

sealed class signupfruitychatui{

    data class FirstNameChanged(val firstName:String) : signupfruitychatui()
    data class LastNameChanged(val lastName:String) : signupfruitychatui()
    data class EmailChanged(val email:String): signupfruitychatui()
    data class PasswordChanged(val password: String) : signupfruitychatui()

    data class PrivacyPolicyCheckBoxClicked(val status:Boolean) : signupfruitychatui()

    object RegisterButtonClicked : signupfruitychatui()
}
