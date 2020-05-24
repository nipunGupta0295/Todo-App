package com.example.tododatabase.DataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context:Context) : SQLiteOpenHelper(
    context,
    "todos.db",
    null,
    1
){
    override fun onCreate(db: SQLiteDatabase?) {     // this is called when the the app is first installed.
        db?.execSQL(TodoTable.CMD_CREATE_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {       // this is called when the database is upgraded.
    }


}