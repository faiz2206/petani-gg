package com.example.petanigg.Repository

import com.example.petanigg.dao.TireDao
import com.example.petanigg.table.TireTable
import kotlinx.coroutines.flow.Flow

class TireRepository(private val tireDao: TireDao) {
    val allTires: Flow<List<TireTable>> = tireDao.getTire()

    suspend fun insert(tire: TireTable) {
        tireDao.insert(tire)
    }

    suspend fun delete(tire: TireTable) {
        tireDao.delete(tire)
    }

    suspend fun update(tire: TireTable) {
        tireDao.update(tire)
    }
}