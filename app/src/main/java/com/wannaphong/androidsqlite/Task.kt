package com.wannaphong.androidsqlite

class Task {
    var id,
    var taskname:String = ""

    constructor(taskname:String){
        this.taskname = taskname
    }
    constructor(id:Int, taskname:String){
        this.id = id
        this.taskname = taskname
    }
}