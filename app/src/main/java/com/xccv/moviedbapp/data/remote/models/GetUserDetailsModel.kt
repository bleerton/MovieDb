package com.xccv.moviedbapp.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetUserDetailsModel(

    @Json(name = "avatar")
    val avatar: Avatar,
    @Json(name = "id")
    val id: Int,
    @Json(name = "include_adult")
    val includeAdult: Boolean,
    @Json(name = "iso_3166_1")
    val iso_3166_1: String,
    @Json(name = "iso_639_1")
    val iso_639_1: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "username")
    val username: String
)