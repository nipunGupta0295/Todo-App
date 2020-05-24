package com.example.tododatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.tododatabase.DataBase.MyDBHelper
import com.example.tododatabase.DataBase.TodoTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val todos = ArrayList<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val todoAdapter = ArrayAdapter<Todo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            todos
        )
        val db = MyDBHelper(this).writableDatabase

        fun refreshTodoList() {
            val todoList = TodoTable.getAllToDos(db)
            todos.clear()
            todos.addAll(todoList)
            todoAdapter.notifyDataSetChanged()
        }
        lvTodo.adapter = todoAdapter
        refreshTodoList()

        btnAddTodo.setOnClickListener {

            val newTodo = Todo(
                etNewTodo.text.toString(),
                false
            )

            TodoTable.insertTodo(db, newTodo)
            refreshTodoList()

        }


    }


}
