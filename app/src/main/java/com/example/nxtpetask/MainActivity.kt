package com.example.nxtpetask

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nxtpetask.components.MandateDetailsPage
import com.example.nxtpetask.model.PageDetails
import com.example.nxtpetask.ui.theme.NxtPeTaskTheme
import com.example.nxtpetask.util.Resource
import com.example.nxtpetask.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NxtPeTaskTheme {
                var loader by remember {mutableStateOf(true)}
                val viewModel = viewModel<HomeViewModel>()
                val data by viewModel.getData().collectAsState()
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    when (data) {
                        is Resource.Success -> {
                            loader = false
                            Greeting(data = data.data)
                        }

                        is Resource.Error -> {
                            Log.d("asdasdas", data.error.toString())
                        }

                        else -> {

                        }

                    }
                }
                if(loader)
                {
                    SimpleCircularProgressComponent()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Greeting(data: PageDetails?) {
        Scaffold(
            topBar = {
                Surface(shadowElevation = 8.dp, modifier = Modifier.background(Color.White)) {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = data?.page_title.toString(),
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.opensans_semibold)),
                            )
                        },
                        navigationIcon = {
                            Icon(
                                Icons.Default.KeyboardArrowLeft,
                                contentDescription = null,
                                tint = Color(android.graphics.Color.parseColor("#FF8200")),
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    )
                }
            },
            content = {
                MandateDetailsPage(paddingValues = it, data = data)
            }
        )

    }
}

@Composable
fun SimpleCircularProgressComponent() {
    Column(

        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        // below line is use to display
        // a circular progress bar.
        CircularProgressIndicator(
            modifier = Modifier.padding(16.dp),
            color = Color(android.graphics.Color.parseColor("#FF8200")),
            strokeWidth = Dp(value = 4F)
        )
    }
}




