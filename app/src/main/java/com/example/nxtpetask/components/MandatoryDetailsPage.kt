package com.example.nxtpetask.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nxtpetask.R
import com.example.nxtpetask.model.PageDetails

@Composable
fun MandateDetailsPage(paddingValues: PaddingValues, data: PageDetails?) {
    var selectedIndex by remember { mutableStateOf(-1) }
    var selectedIndexPay by remember { mutableStateOf(-1) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = paddingValues.calculateTopPadding(),
                start = 20.dp,
                end = 20.dp,
                bottom = paddingValues.calculateBottomPadding()
            )
            .background(Color.White)
    ) {
        item {
            DetailsCard(data)
            if (data != null) {
                Text(
                    text = data.page_items[1].title,
                    modifier = Modifier.padding(top = 30.dp),
                    fontFamily = FontFamily(Font(R.font.opensans_semibold)),
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
            LazyRow {
                if (data != null) {
                    items(data.page_items[1].paymentoptions.size) {
                        PaymentCards(
                            selected = selectedIndex == it,
                            data,
                            it,
                            clickAction = { selectedIndex = it })
                    }
                }
            }
            Text(
                text = "Pay Using",
                modifier = Modifier.padding(top = 30.dp),
                fontFamily = FontFamily(Font(R.font.opensans_semibold)),
                fontSize = 20.sp,
                color = Color.Black
            )

        }
        if (data != null) {
            items(data.page_items[2].customer_linked_account.options.size)
            {
                PayUsingCard(
                    selected = selectedIndexPay == it,
                    data,
                    it,
                    clickAction = { selectedIndexPay = it })
            }
        }
    }
}