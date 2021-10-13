package com.dardev.notecomposeapp.feature.note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dardev.notecomposeapp.feature.note.domain.model.Yanote

@Database(
    entities = [Yanote::class],
    version = 1
)
abstract class YanoteDatabase :RoomDatabase() {

    abstract val yanoteDAO:YanoteDAO

    companion object{
        const val DATABASE_NAME = "yanote_db"
    }
}