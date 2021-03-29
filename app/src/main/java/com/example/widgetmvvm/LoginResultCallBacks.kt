package com.example.widgetmvvm

interface LoginResultCallBacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}