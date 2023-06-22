package com.example.petanigg.application


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.petanigg.dao.TireDao
import com.example.petanigg.table.TireTable

@Database(entities = [TireTable::class], version = 2, exportSchema = false)
abstract class TireDatabase: RoomDatabase() {
    abstract fun tireDao(): TireDao

    companion object {
        private var INSTANCE: TireDatabase? = null

        private val migration1To2: Migration = object: Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE tire_table ADD COLUMN latitude Double DEFAULT 0.0")
                database.execSQL("ALTER TABLE tire_table ADD COLUMN longitude Double DEFAULT 0.0")
            }
        }

        fun getDatabase(
            context: Context
        ): TireDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TireDatabase::class.java,
                    "tire_database"
                )
                    .addMigrations(migration1To2)
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}