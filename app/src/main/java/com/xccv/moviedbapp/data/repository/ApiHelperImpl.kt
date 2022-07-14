package com.xccv.moviedbapp.data.repository

import com.xccv.moviedbapp.data.remote.ApiService
import com.xccv.moviedbapp.data.remote.models.CreateSessionResponseModel
import com.xccv.moviedbapp.data.remote.models.GetUserDetailsModel
import com.xccv.moviedbapp.data.remote.models.LoginRequestModel
import com.xccv.moviedbapp.data.remote.models.LoginResponseModel
import com.xccv.moviedbapp.domain.repository.ApiHelper

class ApiHelperImpl (private val apiService: ApiService) : ApiHelper {

    override suspend fun getRequestToken(): LoginResponseModel {
        return apiService.getRequestToken()
    }

    override suspend fun getValidationFromLogin(loginRequestModel: LoginRequestModel): LoginResponseModel {
        return apiService.getValidationFromLogin(loginRequestModel)
    }

    override suspend fun createSession(): CreateSessionResponseModel {
        return apiService.postCreateSession()
    }

    override suspend fun getUserDetails(sessionId: String): GetUserDetailsModel {
        return apiService.getUserDetails(sessionId)
    }
}