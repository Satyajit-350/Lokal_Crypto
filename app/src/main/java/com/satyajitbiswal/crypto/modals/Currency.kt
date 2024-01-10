package com.satyajitbiswal.crypto.modals

import android.os.Build
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Currency(
    val name: String,
    val symbol: String,
    val icon_url: String,
    val exchangeRate: Double?
){
    val formattedExchangeRate: String get() {
        return exchangeRate?.let {
            val decimalFormat = DecimalFormat("0.######")
            decimalFormat.format(it)
        } ?: "0.0"
    }
}
