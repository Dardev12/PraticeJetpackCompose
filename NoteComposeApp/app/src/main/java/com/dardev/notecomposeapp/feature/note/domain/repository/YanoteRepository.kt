package com.dardev.notecomposeapp.feature.note.domain.repository

import com.dardev.notecomposeapp.feature.note.domain.model.Yanote
import kotlinx.coroutines.flow.Flow

interface YanoteRepository {

    fun avoirYanotes(): Flow<List<Yanote>>

    suspend fun avoirYanoteParId(id:Int): Yanote?

    suspend fun ajouterYanote(yanote: Yanote)

    suspend fun supprimerYanote(yanote: Yanote)
}