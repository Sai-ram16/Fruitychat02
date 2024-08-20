package com.sairam.fruitychat

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sairam.fruitychat.ui.concept.FruitsAppTheme

import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign

class AddtoCartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FruitsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
//            .requiredWidth(width = 360.dp)
//            .requiredHeight(height = 40.dp)
//            .background(color = Color(0xFFFFA500))
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = (8).dp,
                    y = (86).dp)
                .requiredWidth(width = 435.dp)
                .requiredHeight(height = 980.dp)
                .background(color = Color(0xFFFFA500))
        ) {
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(
                        x = 0.dp,
                        y = 382.dp
                    )
                    .requiredWidth(width = 556.dp)
                    .requiredHeight(height = 231.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = Color(0x9FFF5722))
            )

            Text(
                text = "£ 90.00",
                color = Color(0xFF005504),
                textAlign = TextAlign.End,
                style = TextStyle(
                    fontSize = 30.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 261.dp,
                        y = 520.dp)
            )
            Text(
                text = "£ 6.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 280.dp,
                        y = 470.dp))
            Text(
                text = "£ 84.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 280.dp,
                        y = 420.dp))
            Text(
                text = "Fruits Amount Total",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 530.dp))
            Text(
                text = "Shipping charges",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 480.dp))
            Text(
                text = "Sub Total",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 425.dp))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 124.dp,
                        y = 284.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0x774CAF50)))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 124.dp,
                        y = 166.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0x774CAF50)))

            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 204.dp,
                        y = 284.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0x75FF5722)))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 204.dp,
                        y = 166.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0x75FF5722)))
            Text(
                text = "+",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 135.dp,
                        y = 290.dp))
            Text(
                text = "+",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 135.dp,
                        y = 172.dp))
            Text(
                text = "1",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 177.dp,
                        y = 287.dp))
            Text(
                text = "1",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 177.dp,
                        y = 169.dp))

            Text(
                text = "-",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 216.dp,
                        y = 290.dp))
            Text(
                text = "-",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 216.dp,
                        y = 172.dp))

            val context = LocalContext.current
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 37.dp,
                        y = 638.dp)
                    .requiredWidth(width = 321.dp)
                    .requiredHeight(height = 50.dp)
                    .clickable {
                        context.startActivity(
                            Intent(context, PaymentActivity::class.java))
                    }

                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = Color(0x774CAF50)))
            Text(
                text = "Proceed to Checkout",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 120.dp,
                        y = 653.dp))
            Image(
                painter = painterResource(id = R.drawable.grapes),
                contentDescription = "",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 7.dp,
                        y = 229.dp)
                    .requiredWidth(width = 102.dp)
                    .requiredHeight(height = 105.dp)
                    .clip(shape = RoundedCornerShape(15.dp)))
            Image(
                painter = painterResource(id = R.drawable.mangoes),
                contentDescription = "",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 7.dp,
                        y = 104.dp)
                    .requiredWidth(width = 100.dp)
                    .requiredHeight(height = 104.dp)
                    .clip(shape = RoundedCornerShape(24.dp)))
            Text(
                text = "Grapes",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 134.dp,
                        y = 229.dp))
            Text(
                text = "Mangoes",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 134.dp,
                        y = 111.dp))
            Text(

                text = "£ 40.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 294.dp,
                        y = 230.dp))
            Text(
                text = "£ 44.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 294.dp,
                        y = 116.dp))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    FruitsAppTheme {
        Greeting2("Android")
    }
}