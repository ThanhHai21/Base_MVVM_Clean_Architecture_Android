package com.mybasecode.noteapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mybasecode.noteapp.data.database.daos.NoteDao
import com.mybasecode.noteapp.data.entities.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "note-database"
    }

    abstract fun appDao(): NoteDao
}