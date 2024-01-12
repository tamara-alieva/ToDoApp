package com.example.todoapp

import android.app.Application
import androidx.room.Room
import com.example.todoapp.database.TodoDatabase
import org.koin.core.context.startKoin
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
            })
        }
    }
}