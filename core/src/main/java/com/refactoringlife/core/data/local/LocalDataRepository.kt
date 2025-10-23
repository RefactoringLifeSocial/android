package com.refactoringlife.core.data.local

import kotlinx.coroutines.flow.Flow

interface LocalDataRepository<T> {
    suspend fun saveData(data: T)
    suspend fun getData(): T?
    suspend fun clearData()
    fun observe(): Flow<T?>
}
