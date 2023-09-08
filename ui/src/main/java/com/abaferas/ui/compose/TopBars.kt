package com.abaferas.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abaferas.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalTopAppBar(title: String) {
    TopAppBar(title = { Text(text = title) }, actions = {
        Image(
            painter = painterResource(id = R.drawable.topapp_logo),
            contentDescription = "",
            modifier = Modifier.padding(end = 16.dp)
        )
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopAppBar(title: String) {
    CenterAlignedTopAppBar(title = { Text(text = title) })
}