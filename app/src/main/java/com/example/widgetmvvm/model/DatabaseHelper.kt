package com.example.widgetmvvm.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, "data.db", null, 1) {

    private val TABLE_NAME = "tasks"
    private val COL1 = "text"
    private val COL2 = "important"

    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable =
            "create table $TABLE_NAME (id integer primary key autoincrement, $COL1 text, $COL2 integer)"
        p0!!.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun addData(text: String, check: Boolean): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL1, text)
        contentValues.put(COL2, check)
        val result = db.insert(TABLE_NAME, null, contentValues)
        return result != -1L
    }

    fun select(): ArrayList<Data> {
        val arrayList: ArrayList<Data> = ArrayList()
        val db = this.writableDatabase
        val cursor: Cursor = db.rawQuery("select * from $TABLE_NAME", null)

        if (cursor.count == 0) {
            return ArrayList()
        }

        while (cursor.moveToNext()) {
            arrayList.add(Data(cursor.getString(1), cursor.getInt(2) == 1))
        }

        cursor.close()
        return arrayList
    }

    fun selectTrue(): ArrayList<Data> {
        val arrayList: ArrayList<Data> = ArrayList()
        val db = this.writableDatabase
        val cursor: Cursor = db.rawQuery("select * from $TABLE_NAME", null)

        if (cursor.count == 0) {
            return ArrayList()
        }

        while (cursor.moveToNext()) {
            if (cursor.getInt(2) == 1)
                arrayList.add(Data(cursor.getString(1), cursor.getInt(2) == 1))
        }

        cursor.close()
        return arrayList
    }
}