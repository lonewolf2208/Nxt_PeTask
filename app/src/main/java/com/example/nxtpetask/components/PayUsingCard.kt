package com.example.nxtpetask.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.nxtpetask.model.PageDetails


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayUsingCard(selected: Boolean = false, data: PageDetails, i: Int,clickAction:()->Unit) {
    val showDialog =  remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(12.dp),
        onClick = {
            clickAction()
            showDialog.value=true
                  },
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
        , colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        border = if (selected) BorderStroke(
            2.dp,
            Color(android.graphics.Color.parseColor("#FF8200"))
        ) else null
    ) {
        if(showDialog.value)
        {
            DialogBoxCard(setShowDialog = {
                showDialog.value = it
            })
        }
        Row(modifier= Modifier.padding(12.dp),) {
            Image(painter = rememberAsyncImagePainter(data.page_items[2].customer_linked_account.options[i].icon), contentDescription = null, contentScale = ContentScale.FillBounds, modifier = Modifier.size(20.dp))
            Text(
                text = data.page_items[2].customer_linked_account.options[i].text, modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(2f)
                ,
                color=Color.Black
            )
            Image(imageVector = Icons.Default.ArrowForward, contentDescription = null, contentScale = ContentScale.FillBounds)
        }
    }

}