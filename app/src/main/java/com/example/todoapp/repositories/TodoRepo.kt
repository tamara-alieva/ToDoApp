package com.example.todoapp.repositories

import com.example.todoapp.database.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepo {
    suspend fun getTodos():Flow<List<TodoEntity>>
    suspend fun addTodo(todo:TodoEntity)
    suspend fun updateTodo(todo:TodoEntity)
    suspend fun deleteTodo(todo: TodoEntity)
}