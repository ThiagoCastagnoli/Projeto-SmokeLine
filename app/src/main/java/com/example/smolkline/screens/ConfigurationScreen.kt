package com.example.smolkline.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.smolkline.R

@Composable
fun ConfigurationScreen(
    onChangeLanguage: () -> Unit,
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.settings),
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            modifier = Modifier.padding(top = 24.dp),
            onClick = onChangeLanguage
        ) {
            Text(stringResource(R.string.language))
        }

        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = onLogout
        ) {
            Text(stringResource(R.string.log_out))
        }
    }
}