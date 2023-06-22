package com.example.petanigg.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.petanigg.table.TireTable
import kotlinx.coroutines.flow.Flow

@Dao
interface TireDao {
    @Query("SELECT * FROM tire_table ORDER BY name ASC")
    fun getTire(): Flow<List<TireTable>>

    @Insert
    suspend fun insert(tire: TireTable)

    @Delete
    suspend fun delete(tire: TireTable)

    @Update
    suspend fun update(tire: TireTable)
}
