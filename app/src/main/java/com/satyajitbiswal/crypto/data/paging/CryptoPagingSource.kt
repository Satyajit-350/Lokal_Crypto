package com.satyajitbiswal.crypto.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.satyajitbiswal.crypto.data.remote.CryptoApi
import com.satyajitbiswal.crypto.modals.Currency

class CryptoPagingSource(
    private val cryptoApi: CryptoApi
): PagingSource<Int, Currency>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Currency> {
        val page = params.key ?: 1
        return try {
            val currenciesResponse = cryptoApi.getCurrencies()
            val exchangeRateResponse = cryptoApi.getExchangeRates()

            val currencies = currenciesResponse.crypto.values.toList()
            val exchangeRates = exchangeRateResponse.rates

            Log.d("PagingSource", currencies.size.toString())

            val currencyList = currencies.map {currency ->
                Currency(
                    name = currency.name,
                    symbol = currency.symbol,
                    icon_url = currency.icon_url,
                    exchangeRate = exchangeRates[currency.symbol]?:0.0
                )
            }

            LoadResult.Page(
                data = currencyList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Currency>): Int? {
        return state.anchorPosition
    }


}