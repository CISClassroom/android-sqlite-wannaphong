package com.wannaphong.androidsqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val db_version:Int = 1
class DBHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, db_version) {

    val db_name = "todo.db"
    val TABLE = "task"
    val conlumn_id = "id"
    val conlumn_name = "name"

    fun addTask(){

    }
    fun getAllTask(){

    }
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = "CREATE TABLE "+db_name+" (" +
                conlumn_id+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                conlumn_name+" TEXT" +
                ")"
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val update_table = "DROP TABLE IF EXISTS "+TABLE
        db.execSQL(update_table)
        onCreate(db)
    }

}