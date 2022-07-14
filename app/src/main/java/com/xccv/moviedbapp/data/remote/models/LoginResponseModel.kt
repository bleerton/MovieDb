package com.xccv.moviedbapp.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponseModel(
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "expires_at")
    val expiresAt: String,
    @Json(name = "request_token")
    val requestToken: String,
)