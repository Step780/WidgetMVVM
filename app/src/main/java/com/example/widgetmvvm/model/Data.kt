package com.example.widgetmvvm.model

import androidx.databinding.BaseObservable

data class Data(var text: String, var check: Boolean) : BaseObservable() {

    val isDataValid: Boolean
        get() = (text.isNotBlank())
}