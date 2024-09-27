package com.example.foundation.securestorage.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import com.example.foundation.interaction.util.emptyValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.io.IOException

suspend inline fun <reified T> DataStore<Preferences>.getFromLocalStorage(
    preferencesKey: Preferences.Key<T>,
    crossinline func: T.() -> Unit,
) {
    data.catch {
        if (it is IOException) {
            // dataStore.data throws an IOException when an error is encountered when reading data.
            emit(emptyPreferences())
        } else {
            throw it
        }
    }.map {
        it[preferencesKey]
    }.collect {
        it?.let {
            func.invoke(it as T)
        } ?: kotlin.run {
            // Invoke with default empty string, if the key is not present.
            // Otherwise, we are not getting callback.
        }
    }
}

fun DataStore<Preferences>.getFromLocalStorage(
    preferencesKey: Preferences.Key<String>,
): Flow<String> {
    return data.catch {
        if (it is IOException) {
            // dataStore.data throws an IOException when an error is encountered when reading data.
            emit(emptyPreferences())
        } else {
            throw it
        }
    }.map {
        it[preferencesKey] ?: String.emptyValue()
    }.flowOn(Dispatchers.IO)
}

fun <T> DataStore<Preferences>.getData(
    preferencesKey: Preferences.Key<T>,
): Flow<T?> {
    return data.catch {
        if (it is IOException) {
            // dataStore.data throws an IOException when an error is encountered when reading data.
            emit(emptyPreferences())
        } else {
            throw it
        }
    }.map {
        it[preferencesKey]
    }.flowOn(Dispatchers.IO)
}
