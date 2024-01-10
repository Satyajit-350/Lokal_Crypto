package com.satyajitbiswal.crypto.presentation.common

import android.os.Build
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.satyajitbiswal.crypto.modals.Currency
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@ExperimentalCoilApi
@Composable
fun ListContent(
    items: LazyPagingItems<Currency>,
    onRetry: () -> Unit
) {

    var lastRefreshTime by rememberSaveable { mutableStateOf(getRefreshTime()) }

    val handlePagingResult = HandlePagingResult(currencies = items, onRetry = onRetry, refreshTime = {
        lastRefreshTime = getRefreshTime()
    })
    if (handlePagingResult) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .testTag("exchangeRatesList"),
            contentPadding = PaddingValues(all = 12.dp),
        ) {
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = buildAnnotatedString {
                        append("Last Refreshed - ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                            append(lastRefreshTime)
                        }
                    },
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.labelSmall
                )
            }
            items(count = items.itemCount) {
                items[it]?.let { cryptoItem ->
                    CryptoItem(cryptoItem)
                }
            }
        }
    }
}

fun getRefreshTime(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("h:mm a")
        currentDateTime.format(formatter)
    } else {
        ""
    }
}

@Composable
fun HandlePagingResult(
    currencies: LazyPagingItems<Currency>,
    onRetry: () -> Unit,
    refreshTime: () -> Unit
): Boolean {

    val loadState = currencies.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            refreshTime()
            false
        }

        error != null -> {
            EmptyScreen(error, onRetry = onRetry)
            false
        }

        else -> {
            true
        }
    }

}
