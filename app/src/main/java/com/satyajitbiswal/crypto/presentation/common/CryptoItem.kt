package com.satyajitbiswal.crypto.presentation.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.satyajitbiswal.crypto.R
import com.satyajitbiswal.crypto.modals.Currency
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CryptoItem(
    currency: Currency,
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 10.dp),
        elevation = CardDefaults.cardElevation(
            10.dp
        )
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 10.dp)
        ){

            val painter =
                rememberImagePainter(data = currency.icon_url) {
                    crossfade(durationMillis = 200)
                    error(R.drawable.ic_placeholder)
                    placeholder(R.drawable.ic_placeholder)
                }

            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                painter = painter,
                contentDescription = "crypto image"
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 5.dp)
                    .width(80.dp)
                    .weight(1f)
            ) {
                Text(
                    text = currency.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .basicMarquee(),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = currency.symbol,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray
                )
            }

            GraphChart(
                modifier = Modifier.height(40.dp)
                    .width(30.dp)
                    .padding(start = 10.dp, end = 5.dp)
                    .weight(1f),
                list = generateRandomList(5)
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 5.dp)
                ,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = currency.formattedExchangeRate,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

private fun generateRandomList(size: Int): List<Float> {
    return List(size) { Random.nextInt(1, 101).toFloat() }
}

//@Preview(showBackground = true)
//@Composable
//private fun CryptoItemPreview() {
//    CryptoItem()
//}