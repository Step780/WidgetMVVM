package com.example.widgetmvvm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.widgetmvvm.adapter.ListViewAdapter
import com.example.widgetmvvm.model.DatabaseHelper

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ListViewAdapter
    private var db = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.list_view)

        adapter = ListViewAdapter(this, db.select())

        listView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onRestart() {
        adapter.notifyDataSetChanged()
        super.onRestart()
    }

    fun addTask(view: View) {
        val intent = Intent(this, AddTaskActivity::class.java)
        startActivity(intent)
    }
}