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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sairam.fruitychat.ui.concept.FruitsAppTheme

class DetailsPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FruitsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    fruitychat("Android")
                }
            }
        }
    }
}

@Composable
fun fruitychat(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 640.dp)
            .background(color = Color(0xFFFFA500))
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = (7).dp,
                    y = (-20).dp)
                .requiredWidth(width = 425.dp)
                .requiredHeight(height = 980.dp)
                .background(color = Color(0xFFFFA500))
        ) {
            ///1

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FruitsAppTheme {
        fruitychat("Android")
    }
}