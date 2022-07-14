package com.xccv.moviedbapp.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequestModel(
    @Json(name = "username")
    val username: String,
    @Json(name = "password")
    val password: String,
    @Json(name = "request_token")
    val requestToken: String,
)

