package com.example.widgetmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.widgetmvvm.LoginResultCallBacks

class DataViewModelFactory(private val listener: LoginResultCallBacks) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DataViewModel(listener) as T
    }
}