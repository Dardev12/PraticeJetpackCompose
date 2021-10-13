package com.dardev.notecomposeapp.feature.note.data.data_source

import androidx.room.*
import com.dardev.notecomposeapp.feature.note.domain.model.Yanote
import kotlinx.coroutines.flow.Flow

@Dao
interface YanoteDAO {

    @Query("SELECT * FROM Yanote")
    fun avoirYanotes(): Flow<List<Yanote>>

    @Query("SELECT * FROM Yanote WHERE id = :id")
    suspend fun avoirYanoteParId(id:Int):Yanote?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun ajouteYanote(yanote: Yanote)

    @Delete
    suspend fun supprimerYanote(yanote: Yanote)
}