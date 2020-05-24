package com.example.tododatabase.DataBase

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.FontsContract
import com.example.tododatabase.Todo

object TodoTable {
    val TABLE_NAME = "todos"

    object columns {
        val ID = "id"
        val TASK = "task"
        val DONE = "done"
    }

    val CMD_CREATE_TABLE = """
        CREATE TABLE IF NOT EXISTS $TABLE_NAME
        (
        ${columns.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${columns.TASK} TEXT,
        ${columns.DONE} BOOLEAN
        );
        """.trimIndent()

    fun insertTodo(db: SQLiteDatabase, todo: Todo) {
        val row = ContentValues()
        row.put(columns.TASK, todo.task)
        row.put(columns.DONE, todo.done)
        db.insert(TABLE_NAME, null, row)

    }

    fun getAllToDos(db: SQLiteDatabase): ArrayList<Todo> {
        val todos = ArrayList<Todo>()
        var c = db.query(
            TABLE_NAME,
            arrayOf(columns.ID, columns.TASK, columns.DONE),
            null, null, null, null, null, null
        )

        while (c.moveToNext()) {
            val todo = Todo(c.getString(1), c.getInt(2) == 1)
            todos.add(todo)
        }
        return todos
    }
}