package com.xccv.moviedbapp.data.remote

import com.xccv.moviedbapp.data.remote.models.CreateSessionResponseModel
import com.xccv.moviedbapp.data.remote.models.GetUserDetailsModel
import com.xccv.moviedbapp.data.remote.models.LoginRequestModel
import com.xccv.moviedbapp.data.remote.models.LoginResponseModel
import com.xccv.moviedbapp.common.Constants.QUERY_SESSION_ID
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("authentication/token/new")
    suspend fun getRequestToken(): LoginResponseModel

    @POST("authentication/token/validate_with_login")
    suspend fun getValidationFromLogin(
        @Body loginRequestModel: LoginRequestModel
    ): LoginResponseModel

    @POST("/authentication/session/new")
    suspend fun postCreateSession(): CreateSessionResponseModel

    @GET("/account")
    suspend fun getUserDetails(
        @Query(QUERY_SESSION_ID) sessionId: String
    ): GetUserDetailsModel
}