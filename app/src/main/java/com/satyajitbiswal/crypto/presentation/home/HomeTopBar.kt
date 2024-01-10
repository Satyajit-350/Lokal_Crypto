package com.satyajitbiswal.crypto.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuOpen
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            modifier = Modifier.align(Alignment.CenterStart),
            text = "CryptoCompose",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 24.sp,
        )

        Row(
            modifier = Modifier.wrapContentWidth()
                .align(Alignment.CenterEnd)
        ) {
            IconButton(
                onClick = { onSearchClicked() }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search"
                )
            }

            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .padding(horizontal = 5.dp)
                    .align(Alignment.CenterVertically),
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "account",
            )
        }


    }

}

@Preview(showBackground = true)
@Composable
private fun TopBarPreview() {
    HomeTopBar() {

    }
}