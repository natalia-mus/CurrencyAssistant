package com.example.currencyassistant.api

interface RepositoryCallback<T> {

    fun onSuccess(data: T?)
    fun onError()
}