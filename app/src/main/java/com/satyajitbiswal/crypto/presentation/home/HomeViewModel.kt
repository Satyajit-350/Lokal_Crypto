package com.satyajitbiswal.crypto.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.satyajitbiswal.crypto.data.repository.CryptoRepository
import com.satyajitbiswal.crypto.modals.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val cryptoRepository: CryptoRepository
): ViewModel() {


    private val _refreshState = MutableStateFlow(false)
    val refreshState: StateFlow<Boolean> = _refreshState

    //Returns a flow that switches to a new flow every time when the original flow emits a value.
    // When the original flow emits a new value,the previous flow produced by transform block is cancelled.
    @OptIn(ExperimentalCoroutinesApi::class)
    val getCurrencies = refreshState.flatMapLatest { shouldRefresh ->
        if (shouldRefresh) {
            _refreshState.value = false
        }
        cryptoRepository.getCurrencies().cachedIn(viewModelScope)
    }.cachedIn(viewModelScope)

    fun refreshData() {
        _refreshState.value = true
    }

}