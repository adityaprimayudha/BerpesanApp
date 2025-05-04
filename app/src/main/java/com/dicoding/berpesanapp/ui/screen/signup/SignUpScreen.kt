package com.dicoding.berpesanapp.ui.screen.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dicoding.berpesanapp.R
import com.dicoding.berpesanapp.ui.theme.BerpesanAppTheme

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    SignUpContent(modifier = modifier)
}

@Composable
fun SignUpContent(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.img_berpesan),
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 213.dp, width = Dp.Unspecified)
                .padding(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text("Full Name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text("Password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text("Confirm Password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Text("Sign Up")
        }
        Text(text = "Already have an account? Go here")
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    BerpesanAppTheme {
        SignUpScreen()
    }
}
