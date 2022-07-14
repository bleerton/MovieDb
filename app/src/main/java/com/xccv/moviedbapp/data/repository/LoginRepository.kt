package com.xccv.moviedbapp.data.repository

import com.xccv.moviedbapp.common.PreferenceDataStoreManager
import com.xccv.moviedbapp.data.remote.models.LoginRequestModel
import com.xccv.moviedbapp.data.remote.models.LoginResponseModel
import com.xccv.moviedbapp.data.repository.ApiHelperImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository
@Inject constructor(
    private val apiHelperImpl: ApiHelperImpl,
    private val preferenceDataStoreManager: PreferenceDataStoreManager
) {

    suspend fun updateRequestToken() {
        val requestTokenModel = apiHelperImpl.getRequestToken()
        preferenceDataStoreManager.setRequestToken(requestTokenModel.requestToken)
    }

    suspend fun getValidationFromLogin(username: String, password: String): LoginResponseModel {
        return apiHelperImpl.getValidationFromLogin(
            LoginRequestModel(
            username = username,
            password = password,
            requestToken = preferenceDataStoreManager.getRequestToken()
        )
        )
    }

}