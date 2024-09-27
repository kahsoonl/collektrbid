package com.example.foundation.securestorage.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.foundation.securestorage.datastore.keys.PreferenceKeys
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataStoreManager @Inject constructor(
    val context: Context,
) {
    companion object {
        const val DATASTORE = "datastore"
        val USER_SPECIFIC_KEYS = listOf(
            PreferenceKeys.IS_FRESH_INSTALL
        )
    }

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = DATASTORE,
    )

    /**
     * Store the data into the datastore.
     * @param key: key to store the data - Use the same key to retrieve the data.
     * @param value: the data to be stored
     */
    suspend inline fun <reified T> storeValue(
        key: Preferences.Key<T>,
        value: Any,
    ) {
        context.dataStore.edit {
            it[key] = value as T
        }
    }

    /**
     * Retrieve the data.
     * @param key: key which was used to store the data
     * @param responseFunc: invoke and return the retrieved data
     */
    suspend inline fun <reified T> readValue(
        key: Preferences.Key<T>,
        crossinline responseFunc: T.() -> Unit,
    ) {
        context.dataStore.getFromLocalStorage(key) {
            responseFunc.invoke(this)
        }
    }

    /**
     * Retrieve the data.
     * @param key: key which was used to store the data
     */
    fun readString(key: Preferences.Key<String>) =
        context.dataStore.getFromLocalStorage(key)

    /**
     * Retrieve the data.
     * @param key: key which was used to store the data
     */
    fun readBoolean(key: Preferences.Key<Boolean>): Flow<Boolean?> = context.dataStore.getData(key)

    /**
     * Remove a preferences from the [DataStore].
     * @param key: key which was used to store the data
     */
    suspend inline fun <reified T> clearDataByKey(key: Preferences.Key<T>) {
        context.dataStore.edit {
            it.remove(key)
        }
    }

    /**
     * Clear the user-specific details upon logout.
     */
    suspend fun clearDataStore() {
        USER_SPECIFIC_KEYS.forEach { keys ->
            context.dataStore.edit {
                it.remove(keys)
            }
        }
    }
}
