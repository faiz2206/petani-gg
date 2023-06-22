package com.example.petanigg.application

import android.app.Application
import com.example.petanigg.Repository.TireRepository


class TireApplication: Application() {
    val database by lazy { TireDatabase.getDatabase(this) }
    val repository by lazy { TireRepository(database.tireDao()) }
}