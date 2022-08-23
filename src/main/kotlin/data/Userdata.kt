package com.example.data

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val countryCode: String? = null,
    val mobileNumber: String? = null,
    val emailId: String? = null,
)