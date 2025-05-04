package com.dicoding.berpesanapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostItem(
    modifier: Modifier = Modifier,
    date: String,
    title: String,
    content: String,
    name: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = date,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
        )
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(
            text = content,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .border(3.dp, Color.Black, CircleShape)
                    .size(48.dp)
                    .background(Color.Yellow)
            ) {
            }
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PostItemPreview() {
    PostItem(
        date = "26 Maret 2025",
        title = "Ini lagu enak banget coy, sumpah brooo enak banget lagunyaaa",
        name = "Aditya",
        content = "AWODOAWDAWODAWODAJWDOASJKODKWAODKOASKDOWd"
    )
}