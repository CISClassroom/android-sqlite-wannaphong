package com.wannaphong.androidsqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    val db_name = "todo.db"
    val db_version = 1
    val TABLE = "task"
    val conlumn_id = "id"
    val conlumn_name = "name"

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE "+db_name+" (" +
                conlumn_id+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                conlumn_name+" TEXT" +
                ")"
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}