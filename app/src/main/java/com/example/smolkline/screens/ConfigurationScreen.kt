package com.example.smolkline.screens

import android.graphics.drawable.Icon
import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smolkline.R
import com.example.smolkline.ui.theme.SmolkLineTheme
import kotlinx.coroutines.flow.merge


@Composable
fun ConfigurationScreen(
    onChangeLanguage: () -> Unit,
    onLogout: () -> Unit,
    modifier: Modifier
) {
    Box(
            modifier = modifier
                .fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.backgorund_login),
            contentDescription = null,
            modifier = modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop)
    }
    Column {
        Text(stringResource(R.string.settings),
            modifier = modifier
                .padding(start = 20.dp, top = 10.dp) ,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
    )

        UserCard(modifier = Modifier)

        SettingsCard(
            onChangeLanguage = onChangeLanguage,
            onLogout = onLogout,
            modifier = modifier
        )
    }
}
@Composable
private fun UserCard(modifier: Modifier){

    Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp,
                end = 20.dp),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
            containerColor = Color(0xFF041846) ),
            border = BorderStroke(
            1.dp,
                Color.White.copy(alpha = .08f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

    Box(
        modifier = Modifier
        .padding(end = 10.dp)
        .size(42.dp)
        .background(
            Color.White,
            RoundedCornerShape(2.dp)
        )
    )
          Column(modifier = Modifier
              .padding(top = 10.dp)
              .padding(bottom = 10.dp)) {
              Text(
                  text = "Thiaguinho",
                  fontSize = 22.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
              )
              Text(
                  text = stringResource(R.string.email),
                  fontSize = 15.sp,
                  color = Color.White
              )
          }
        }
    }
}
@Composable
private fun SettingsCard(
    onChangeLanguage: () -> Unit,
    onLogout: () -> Unit,
    modifier: Modifier
){
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(
            top = 20.dp,
            start = 20.dp,
            end = 20.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF041846)
        )
    ) {
        Column(
            modifier = modifier
            .padding(
                horizontal = 18.dp,
                vertical = 18.dp
            )
        ) {
            SettingRow(
                modifier = Modifier
                    .padding(bottom = 10.dp),
                icon = Icons.Default.Edit,
                iconColor = Color(0xff2e73ff),
                text = stringResource(R.string.edit_profile)
            )
            SettingRow(
                modifier = Modifier
                    .padding(top = 10.dp),
                icon = Icons.Default.Info,
                iconColor = Color(0xff2e73ff),
                text = stringResource(R.string.notifications)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Language,
                    contentDescription = null,
                    tint = Color(0xff2e73ff),
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 5.dp)
                )
                Button(
                    modifier = Modifier
                        .padding(start = 15.dp),
                    onClick = onChangeLanguage,
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF070707)
                    ),
                    contentPadding = PaddingValues(
                        horizontal = 22.dp,
                        vertical = 8.dp
                    )
                ){
                    Text(stringResource(R.string.language),
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.PowerSettingsNew,
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .padding(end = 5.dp, top = 5.dp)
                )
                Button(onClick = onLogout,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 10.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF070707)
                    )
                ) {
                    Text(stringResource(R.string.log_out),
                        color = Color(0xFFE53935),
                        fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
@Composable
private fun SettingRow(
    icon: ImageVector,
    iconColor: Color,
    text: String,
    modifier: Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier
                .size(26.dp)
        )
        Text(
            modifier = modifier
                .padding(20.dp),
            text = text,
            fontSize = 20.sp,
            color = Color.White)
    }
}
@Preview(showBackground = true)
@Composable
fun ConfigurationScreenPreview() {
    SmolkLineTheme {
        ConfigurationScreen(
            onChangeLanguage = {},
            onLogout = {},
            modifier = Modifier
        )
    }
}