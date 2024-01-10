package com.satyajitbiswal.crypto.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.satyajitbiswal.crypto.modals.Currency
import com.satyajitbiswal.crypto.presentation.common.ListContent
import kotlinx.coroutines.delay
import kotlin.concurrent.fixedRateTimer

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HomeScreen(
    currencies: LazyPagingItems<Currency>,
    onRefresh: () -> Unit
) {

    //Refresh in every 3 min
    DisposableEffect(true){
        val refreshTime = fixedRateTimer(
            name = "RefreshTimer",
            initialDelay = 3 * 60 * 1000L,
            period = 3 * 60 * 1000L
        ){
            onRefresh()
        }
        onDispose{
            refreshTime.cancel()
        }
    }

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)

    SwipeRefresh(
        modifier = Modifier.testTag("swipeToRefresh"),
        state = swipeRefreshState,
        onRefresh = {
            onRefresh()
            swipeRefreshState.isRefreshing = false
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                HomeTopBar(
                    onSearchClicked = {}
                )
                Spacer(modifier = Modifier.height(2.dp))

                ListContent(items = currencies, onRetry = onRefresh)
            }
        }
    }

}