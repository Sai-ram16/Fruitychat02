package com.sairam.fruitychat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sairam.fruitychat.fruitchatcomponents.HeadingTextComponent
import com.sairam.fruitychat.ui.concept.Primary

class PaymentActivity : ComponentActivity() {

    @SuppressLint("SuspiciousIndentation")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val context = LocalContext.current
            val gradient45 = Brush.linearGradient(
                colors = listOf(Color(0xFFFFA500), Color(0xFFFFA500)),
                start = Offset(0f, Float.POSITIVE_INFINITY),
                end = Offset(Float.POSITIVE_INFINITY, 0f)
            )

           //1
        }
    }
}

//2

@Composable
fun MyForm() {
    Column {
       //3
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewOfSignUpScreen() {
    PaymentActivity().setContent {
        PaymentActivity().onCreate(null) // Preview content
    }
}
