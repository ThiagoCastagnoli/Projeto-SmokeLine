package com.example.smolkline.screens

import android.graphics.drawable.Icon
import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
    onLogout: () -> Unit
) {

    Box(modifier = Modifier
        .fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.backgorund_login),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
    }
    Column() {
    Text(stringResource(R.string.settings),
        modifier = Modifier.padding(start = 20.dp, top = 10.dp) ,
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
        Spacer(modifier = Modifier
            .height(28.dp))

        UserCard()

        Spacer(modifier = Modifier
            .height(22.dp))

        SettingsCard(
            onChangeLanguage = onChangeLanguage,
            onLogout = onLogout
        )

    }


}

@Composable
private fun UserCard(){


    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF041846)
        ),
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

    Box(modifier = Modifier
        .size(42.dp)
        .background(
            Color.White,
            RoundedCornerShape(2.dp)
        )
    )


            Spacer(modifier = Modifier.width(22.dp))

          Column() {
              Text(
                  text = "Thiaguinho",
                  fontSize = 22.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
              )

              Spacer(modifier = Modifier
                  .width(22.dp))

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
    onLogout: () -> Unit
){

    Card(modifier = Modifier
        .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF041846)
        )
    ) {

        Column( modifier = Modifier
            .padding(
                horizontal = 18.dp,
                vertical = 18.dp
            )
        ) {
            SettingRow(
                icon = Icons.Default.Edit,
                iconColor = Color(0xff2e73ff),
                text = stringResource(R.string.edit_profile)
            )
            Spacer(modifier = Modifier
                .height(20.dp))

            SettingRow(
                icon = Icons.Default.Info,
                iconColor = Color(0xff2e73ff),
                text = stringResource(R.string.notifications)
            )
            Spacer(modifier = Modifier
                .height(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    imageVector = Icons.Default.Language,
                    contentDescription = null,
                    tint = Color(0xff2e73ff),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier
                    .width(16.dp))

                Button(
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
            Spacer(modifier = Modifier.height(28.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    imageVector = Icons.Default.PowerSettingsNew,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = onLogout,
                    modifier = Modifier
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
    text: String
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

        Spacer(modifier = Modifier.width(15.dp))

        Text(text = text,
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
            onLogout = {}
        )
    }
}