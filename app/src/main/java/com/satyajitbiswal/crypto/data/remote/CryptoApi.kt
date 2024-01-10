package com.satyajitbiswal.crypto.data.remote

import com.satyajitbiswal.crypto.BuildConfig
import com.satyajitbiswal.crypto.modals.CryptoLiveResponse
import com.satyajitbiswal.crypto.modals.CurrenciesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {

    @GET("live")
    suspend fun getExchangeRates(
        @Query("access_key") accessKey: String = BuildConfig.API_KEY
    ): CryptoLiveResponse

    @GET("list")
    suspend fun getCurrencies(
        @Query("access_key") accessKey: String = BuildConfig.API_KEY
    ): CurrenciesResponse

}