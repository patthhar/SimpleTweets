package me.darthwithap.android.simpletweets.domain.util

sealed class Result<T> {
  object Loading : Result<Nothing>()
  data class Success<T>(val data: T, val msg: String? = null) : Result<T>()
  data class Error<T>(val msg: String, val data: T? = null) : Result<T>()
}
