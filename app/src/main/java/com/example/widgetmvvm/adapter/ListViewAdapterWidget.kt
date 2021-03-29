package com.example.widgetmvvm.adapter

import android.content.Context
import android.widget.RemoteViews
import android.widget.RemoteViewsService.RemoteViewsFactory
import com.example.widgetmvvm.R
import com.example.widgetmvvm.model.Data
import com.example.widgetmvvm.model.DatabaseHelper

class ListViewAdapterWidget(private var context: Context) : RemoteViewsFactory {

    private lateinit var data: ArrayList<Data>
    private var db: DatabaseHelper

    init {
        db = DatabaseHelper(context)
    }

    override fun onCreate() {
        data = ArrayList()
    }

    override fun onDataSetChanged() {
        data.clear()
        db = DatabaseHelper(context)
        data = db.selectTrue()
    }

    override fun onDestroy() {

    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getViewAt(position: Int): RemoteViews {
        val remoteViews = RemoteViews(context.packageName, R.layout.list_item)
        remoteViews.setTextViewText(R.id.listItemTextView, data[position].text)
        return remoteViews
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }
}