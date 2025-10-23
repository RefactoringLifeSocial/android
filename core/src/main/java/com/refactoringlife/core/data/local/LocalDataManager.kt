package com.refactoringlife.core.data.local

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class LocalDataManager private constructor() {

    companion object {
        @Volatile
        private var INSTANCE: LocalDataManager? = null

        fun getInstance(): LocalDataManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: LocalDataManager().also { INSTANCE = it }
            }
        }
    }

    private val dataStore = mutableMapOf<String, Any>()
    private val mutex = Mutex()

    suspend fun <T> saveData(key: String, data: T) {
        mutex.withLock {
            dataStore[key] = data as Any
        }
    }

    suspend fun <T> getData(key: String): T? {
        return mutex.withLock {
            dataStore[key] as? T
        }
    }

    suspend fun removeData(key: String) {
        mutex.withLock {
            dataStore.remove(key)
        }
    }
}
