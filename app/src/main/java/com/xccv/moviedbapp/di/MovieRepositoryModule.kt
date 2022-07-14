package com.xccv.moviedbapp.di

import com.xccv.moviedbapp.common.PreferenceDataStoreManager
import com.xccv.moviedbapp.data.repository.ApiHelperImpl
import com.xccv.moviedbapp.data.remote.ApiService
import com.xccv.moviedbapp.data.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieRepositoryModule {

    @Provides
    @Singleton
    fun providesMovieRepositoryModule(apiHelperImpl: ApiHelperImpl, preferenceDataStoreManager: PreferenceDataStoreManager): LoginRepository {
        return LoginRepository(apiHelperImpl, preferenceDataStoreManager)
    }

    @Provides
    @Singleton
    fun providesApiHelperImpl(apiService: ApiService): ApiHelperImpl = ApiHelperImpl(apiService)
}