package com.wannaphong.androidsqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
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

    fun addTask(newTask:Task){
        val values = ContentValues();
        values.put(conlumn_name,newTask.taskname)

        val db = this.writableDatabase

        db.insert(TABLE,null,values)
        db.close()
    }
    fun getAllTask(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM "+TABLE,null)
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