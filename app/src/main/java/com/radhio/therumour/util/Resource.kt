package com.radhio.therumour.util

/**
 * Created by Azmia Hoque Radhio on 3/12/2022.
 */
sealed class Resource<T>(
    val data : T? = null,
    val message: String? = null
) {
    class Success<T> (data: T) : Resource<T>(data)
    class Error<T> (message: String, data: T?=null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}