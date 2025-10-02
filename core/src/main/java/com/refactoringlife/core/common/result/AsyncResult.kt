package com.refactoringlife.core.common.result

sealed class AsyncResult<out T> {

    data object Idle : AsyncResult<Nothing>()
    data object Loading : AsyncResult<Nothing>()
    data class Success<T>(val data: T) : AsyncResult<T>()
    data class Error(
        val error: Throwable,
        val message: String? = null
    ) : AsyncResult<Nothing>()
}

//Extensiones para AsyncResult
inline fun <T> AsyncResult<T>.onIdle(action: () -> Unit): AsyncResult<T> {
    if (this is AsyncResult.Idle) action()
    return this
}

inline fun <T> AsyncResult<T>.onLoading(action: () -> Unit): AsyncResult<T> {
    if (this is AsyncResult.Loading) action()
    return this
}

inline fun <T> AsyncResult<T>.onSuccess(action: (T) -> Unit): AsyncResult<T> {
    if (this is AsyncResult.Success) action(data)
    return this
}

inline fun <T> AsyncResult<T>.onError(action: (Throwable, String?) -> Unit): AsyncResult<T> {
    if (this is AsyncResult.Error) action(error, message)
    return this
}


//Mapea el resultado exitoso a otro tipo
inline fun <T, R> AsyncResult<T>.map(transform: (T) -> R): AsyncResult<R> {
    return when (this) {
        is AsyncResult.Idle -> AsyncResult.Idle
        is AsyncResult.Loading -> AsyncResult.Loading
        is AsyncResult.Success -> AsyncResult.Success(transform(data))
        is AsyncResult.Error -> AsyncResult.Error(error, message)
    }
}

fun <T> AsyncResult<T>.isSuccess(): Boolean = this is AsyncResult.Success
fun <T> AsyncResult<T>.isError(): Boolean = this is AsyncResult.Error
fun <T> AsyncResult<T>.isLoading(): Boolean = this is AsyncResult.Loading
fun <T> AsyncResult<T>.getDataOrNull(): T? = (this as? AsyncResult.Success)?.data