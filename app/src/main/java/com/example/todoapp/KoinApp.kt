package com.example.todoapp

import android.app.Application
import androidx.room.Room
import com.example.todoapp.database.TodoDatabase
import com.example.todoapp.repositories.TodoRepo
import com.example.todoapp.repositories.TodoRepoImpl
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class KoinApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(module {
                single {
                    Room
                        .databaseBuilder(this@KoinApp, TodoDatabase::class.java, "db")
                        .build()
                }
                single {
                    TodoRepoImpl(database = get())
                } bind TodoRepo::class
            })
        }
    }
}