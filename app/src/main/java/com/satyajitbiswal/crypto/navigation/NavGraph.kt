package com.satyajitbiswal.crypto.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.satyajitbiswal.crypto.presentation.home.HomeScreen
import com.satyajitbiswal.crypto.presentation.home.HomeViewModel

@Composable
fun NavGraph(
    navHostController: NavHostController,
) {

    NavHost(
        navController = navHostController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            val getAllCurrencies = homeViewModel.getCurrencies.collectAsLazyPagingItems()
            HomeScreen(getAllCurrencies){
                homeViewModel.refreshData()
            }
        }

    }

}