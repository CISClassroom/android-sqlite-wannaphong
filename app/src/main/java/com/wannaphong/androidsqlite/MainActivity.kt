package com.wannaphong.androidsqlite

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db_name = "todo.db"

        addbtn.setOnClickListener {
            val dbHelper = DBHelper(this,db_name,null,1)
            val newTask:Task = Task(TaskEdit.text.toString())
            dbHelper.addTask(newTask)

            Toast.makeText(this, "OK! : Add to DB "+TaskEdit.text.toString(),Toast.LENGTH_SHORT).show()
        }
        readbtn.setOnClickListener {
            val dbHelper = DBHelper(this,db_name,null,1)
            val data:Cursor? = dbHelper.getAllTask()

            data!!.moveToFirst()

            showtask.text = ""
            do{
                val name = data.getString(data.getColumnIndex("name"))
                val id = data.getString(data.getColumnIndex("id"))
                showtask.append(id+" "+name)
                showtask.append("\n")
            }while(data.moveToNext())
            data.close()
        }
        delbtn.setOnClickListener {
            val dbHelper = DBHelper(this,db_name,null,1)
            val id = edittext.text.toString().toInt()
            val result = dbHelper.deleteTask(id).toString().toBoolean()
            if(result)
                Toast.makeText(this, "OK! : Fall Del is false",Toast.LENGTH_SHORT).show()
            else{
                Toast.makeText(this, "OK! : Del is true",Toast.LENGTH_SHORT).show()
            }
        }
        editbtn.setOnClickListener {
            val dbHelper = DBHelper(this,db_name,null,1)
            val v = edittext.text.toString().split(",")
            val data = v[1]
            val id = v[0].toInt()
            val newTask:Task = Task(edittext.text.toString())
            newTask.id = id;
            newTask.taskname = data
            val result = dbHelper.updateTask(newTask).toString().toBoolean()
            if(result)
                Toast.makeText(this, "OK! : Fall Update is false",Toast.LENGTH_SHORT).show()
            else{
                Toast.makeText(this, "OK! : Update is true",Toast.LENGTH_SHORT).show()
            }

        }
    }
}
