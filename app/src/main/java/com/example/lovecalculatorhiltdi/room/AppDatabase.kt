package com.example.lovecalculatorhiltdi.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculatorhiltdi.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun loveDao():LoveDao

}