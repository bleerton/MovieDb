package com.xccv.moviedbapp.domain.repository

import com.xccv.moviedbapp.data.remote.models.CreateSessionResponseModel
import com.xccv.moviedbapp.data.remote.models.GetUserDetailsModel
import com.xccv.moviedbapp.data.remote.models.LoginRequestModel
import com.xccv.moviedbapp.data.remote.models.LoginResponseModel

interface ApiHelper {

    suspend fun getRequestToken(): LoginResponseModel

    suspend fun getValidationFromLogin(loginRequestModel: LoginRequestModel): LoginResponseModel

    suspend fun createSession(): CreateSessionResponseModel

    suspend fun getUserDetails(sessionId: String): GetUserDetailsModel
}