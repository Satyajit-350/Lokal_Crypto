package com.satyajitbiswal.crypto.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.satyajitbiswal.crypto.data.paging.CryptoPagingSource
import com.satyajitbiswal.crypto.data.remote.CryptoApi
import com.satyajitbiswal.crypto.modals.Currency
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CryptoRepository @Inject constructor(
    private val cryptoApi: CryptoApi
) {

    fun getCurrencies(): Flow<PagingData<Currency>>{
        return Pager(
            config = PagingConfig(
                pageSize = 15,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CryptoPagingSource(cryptoApi)
            }
        ).flow
    }

}