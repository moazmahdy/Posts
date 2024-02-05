package com.example.domain.utils

sealed class ResponseState<out R> {
    data class Success<out T>(val data: T): ResponseState<T>()
    data class Failed(val e: Exception): ResponseState<Nothing>()
    object Loading: ResponseState<Nothing>()
    object Idle: ResponseState<Nothing>()
}