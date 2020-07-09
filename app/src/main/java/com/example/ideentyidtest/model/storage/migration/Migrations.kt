package com.example.ideentyidtest.model.storage.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE New_User (login TEXT)")
        database.execSQL("INSERT INTO New_User (login,id) SELECT login, id FROM User")
        database.execSQL("DROP TABLE User")
        database.execSQL("ALTER TABLE New_User RENAME TO User")
    }
}