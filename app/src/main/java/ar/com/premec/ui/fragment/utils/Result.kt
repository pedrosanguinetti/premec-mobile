package ar.com.premec.ui.fragment.utils

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error<out T>(val exception: Exception) : Result<T>()
    class Loading<out T> : Result<T>()
}