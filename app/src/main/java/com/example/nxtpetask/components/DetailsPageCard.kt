package com.example.nxtpetask.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nxtpetask.R
import com.example.nxtpetask.model.PageDetails


@Composable
fun DetailsCard(data: PageDetails?) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ), modifier = Modifier.padding(top = 24.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                if (data != null) {
                    Text(
                        text = data.page_items[0].mandate_details.details[0].key + "- ",
                        textAlign = TextAlign.Start ,
                        fontFamily = FontFamily(Font(R.font.opensans_regular)),
                        fontSize = 12.sp,
                        color=Color.Black
                    )
                }
                if (data != null) {
                    Text(
                        text = data.page_items[0].mandate_details.details[0].value,
                        fontFamily = FontFamily(Font(R.font.opensans_semibold)),
                        fontSize = 12.sp,
                        color=Color.Black
                    )
                }
                if (data != null) {
                    Text(
                        text = data.page_items[0].mandate_details.details[2].key,
                        modifier = Modifier.padding(start = 12.dp),
                        fontFamily = FontFamily(Font(R.font.opensans_regular)),
                        fontSize = 12.sp,
                        color=Color.Black
                    )
                }
                if (data != null) {
                    Text(
                        text = data.page_items[0].mandate_details.details[2].value,
                        modifier = Modifier.padding(start = 4.dp),
                        fontFamily = FontFamily(Font(R.font.opensans_semibold)),
                        fontSize = 12.sp,
                        color=Color.Black
                    )
                }

            }
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                if (data != null) {
                    Text(text = data.page_items[0].mandate_details.details[1].key+" - ", fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.opensans_regular)),
                        color=Color.Black)
                }
                Text(text = "As Presented", fontFamily = FontFamily(Font(R.font.opensans_semibold)),
                    fontSize = 12.sp,
                    color=Color.Black)
            }
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
                Row(
                    modifier = Modifier
                        .background(
                            Color(android.graphics.Color.parseColor("#FF8200")).copy(alpha = 0.1f)
                        )
                        .padding(top = 10.dp, bottom = 10.dp, start = 16.dp, end = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = Color(android.graphics.Color.parseColor("#FF8200"))
                    )
                    if (data != null) {
                        Text(text = buildAnnotatedString {

                            withStyle(
                                style = SpanStyle(fontFamily =FontFamily(Font(R.font.opensans_regular)) ,
                                    color=Color.Black)
                            ){
                                append(data.page_items[0].mandate_details.message + "\nThe Limit is Upto ")
                            }
                            withStyle(
                                style = SpanStyle(fontFamily =FontFamily(Font(R.font.opensans_bold)),
                                    color=Color.Black )
                            )
                            {
                                append(data.page_items[0].mandate_details.details[2].value)
                            }
                        } )


                    }
                }
            }
        }
    }
}

