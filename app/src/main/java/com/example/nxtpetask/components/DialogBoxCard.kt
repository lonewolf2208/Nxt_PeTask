package com.example.nxtpetask.components

import LoadingAnimation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.nxtpetask.R
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun DialogBoxCard(setShowDialog: (Boolean) -> Unit) {
    Dialog(onDismissRequest = {setShowDialog(false) })
    {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(24.dp)
            ) {
                var timer by remember { mutableStateOf(20) }
                LaunchedEffect(key1 = timer) {
                    if (timer > 0) {
                        delay(1_000)
                        timer -= 1
                    }
                    else setShowDialog(false)
                }
                Text(
                    text = "00:" + timer.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    color = Color(android.graphics.Color.parseColor("#FF8200")),
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterHorizontally),
                    fontFamily = FontFamily(Font(R.font.opensans_semibold)),

                )
                Text(
                    text = "Please approve the request sent to your mobile phone",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.opensans_regular)),
                    modifier = Modifier.padding(top = 10.dp)
                    ,
                    color=Color.Black
                )

                LoadingAnimation(
                    circleColor = Color(android.graphics.Color.parseColor("#FF8200")),
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 16.dp)
                )
            }
        }
    }
}

