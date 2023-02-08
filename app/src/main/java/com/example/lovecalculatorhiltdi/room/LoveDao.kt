package com.example.lovecalculatorhiltdi.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculatorhiltdi.remote.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_table ORDER BY firstName")
    fun getAll():List<LoveModel>

}