package com.example.widgetmvvm.viewmodel

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.ViewModel
import com.example.widgetmvvm.LoginResultCallBacks
import com.example.widgetmvvm.MainActivity
import com.example.widgetmvvm.model.Data
import com.example.widgetmvvm.model.DatabaseHelper

class DataViewModel(private val listener: LoginResultCallBacks) : ViewModel() {

    private val data: Data = Data("", false)
    lateinit var db: DatabaseHelper

    val textWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                data.text = p0.toString()
            }
        }

    fun checkBoxClick(view: View) {
        data.check = (view as CheckBox).isChecked
    }

    fun addTask(view: View) {
        if (data.isDataValid) {
            db = DatabaseHelper(view.context)
            db.addData(data.text, data.check)
            view.context.startActivity(Intent(view.context, MainActivity::class.java))
            listener.onSuccess("Task added")
        } else {
            listener.onError("Validation error")
        }
    }
}