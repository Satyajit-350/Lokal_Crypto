package com.satyajitbiswal.crypto.modals

data class CryptoLiveResponse(
    val privacy: String,
    val rates: Map<String, Double>,
    val success: Boolean,
    val target: String,
    val terms: String,
    val timestamp: Int
)