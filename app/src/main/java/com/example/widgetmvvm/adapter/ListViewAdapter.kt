package com.example.widgetmvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.widgetmvvm.R
import com.example.widgetmvvm.model.Data

class ListViewAdapter(private var activity: Context, private var items: ArrayList<Data>) :
    BaseAdapter() {

    private class ViewHolder(row: View) {
        var listItemTextView: TextView = row.findViewById(R.id.listItemTextView)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater =
                activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = items[position]
        viewHolder.listItemTextView.text = item.text

        return view
    }

    override fun getItem(i: Int): Data {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}