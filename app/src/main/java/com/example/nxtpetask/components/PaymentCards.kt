package com.example.nxtpetask.components

import android.service.autofill.OnClickAction
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.nxtpetask.model.PageDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentCards(selected: Boolean = false, data: PageDetails,ind:Int,clickAction:()->Unit) {
    Card(
        modifier = Modifier
            .height(140.dp)
            .width(140.dp)
            .padding(12.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        onClick = {clickAction()},
        border = if (selected) BorderStroke(
            2.dp,
            Color(android.graphics.Color.parseColor("#FF8200"))
        ) else null
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (selected) Color(android.graphics.Color.parseColor("#FF8200")).copy(
                        0.1f
                    ) else Color.White
                )
        ) {
           Image(painter = rememberAsyncImagePainter(data.page_items[1].paymentoptions[ind].icon), contentDescription = null, contentScale = ContentScale.FillBounds)
        }

    }
}