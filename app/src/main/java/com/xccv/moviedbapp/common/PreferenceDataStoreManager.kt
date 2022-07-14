package com.xccv.moviedbapp.common

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xccv.moviedbapp.common.Constants.IS_USER_LOGGED_IN_KEY
import com.xccv.moviedbapp.common.Constants.MOVIE_PREFERENCE_DATASTORE
import com.xccv.moviedbapp.common.Constants.REQUEST_TOKEN_KEY
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = MOVIE_PREFERENCE_DATASTORE)

@Module
@InstallIn(SingletonComponent::class)
class PreferenceDataStoreManager @Inject constructor(@ApplicationContext val context: Context) {

    private val REQUEST_TOKEN = stringPreferencesKey(REQUEST_TOKEN_KEY)
    private val IS_USER_LOGGED_IN = booleanPreferencesKey(IS_USER_LOGGED_IN_KEY)

    suspend fun getRequestToken() = context.dataStore.data.map { preferences ->
        preferences[REQUEST_TOKEN] ?: "null"
    }.first()

    suspend fun setRequestToken(requestToken: String) = context.dataStore.edit { preferences ->
        run {
            preferences[REQUEST_TOKEN] = requestToken
        }
    }

    fun getIsUserLoggedIn() = context.dataStore.data.map { preferences ->
        preferences[IS_USER_LOGGED_IN]
    }

    suspend fun setIsUserLoggedIn(status: Boolean) = context.dataStore.edit { prefereces ->
        run {
            prefereces[IS_USER_LOGGED_IN] = status
        }
    }
}