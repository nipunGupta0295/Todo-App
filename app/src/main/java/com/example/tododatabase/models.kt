package com.example.tododatabase

data class Todo(val task:String,val done:Boolean){
    override fun toString(): String {
        return this.task
    }
}