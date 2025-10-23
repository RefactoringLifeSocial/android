package com.refactoringlife.core.data.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Implementación del repositorio de datos locales.
 * Combina persistencia con reactive programming.
 */
class DataRepositoryImpl<T>(
    private val key: String,
    private val localDataManager: LocalDataManager = LocalDataManager.getInstance()
) : LocalDataRepository<T> {

    private val _dataFlow = MutableStateFlow<T?>(null)
    val dataFlow: StateFlow<T?> = _dataFlow

    override suspend fun saveData(data: T) {
        localDataManager.saveData(key, data)
        _dataFlow.value = data
    }

    override suspend fun getData(): T? {
        return _dataFlow.value ?: run {
            val data = localDataManager.getData<T>(key)
            _dataFlow.value = data
            data
        }
    }

    override suspend fun clearData() {
        localDataManager.removeData(key)
        _dataFlow.value = null
    }

    override fun observe(): Flow<T?> = _dataFlow
}
