package com.example.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.serialization.Serializable


@JsonIgnoreProperties(ignoreUnknown = false)
@Serializable
data class Response(
    val id: String,
    val primaryEmailId: String?,
)
