package com.example.euroexchangerate.api

interface RepositoryCallback<T> {

    fun onSuccess(data: T?)
    fun onError()
}