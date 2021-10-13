package com.dardev.notecomposeapp.feature.note.data.repository

import com.dardev.notecomposeapp.feature.note.data.data_source.YanoteDAO
import com.dardev.notecomposeapp.feature.note.domain.model.Yanote
import com.dardev.notecomposeapp.feature.note.domain.repository.YanoteRepository
import kotlinx.coroutines.flow.Flow

class YanoteRepositoryImpl(
    private val dao:YanoteDAO
):YanoteRepository {
    override fun avoirYanotes(): Flow<List<Yanote>> {
        return dao.avoirYanotes()
    }

    override suspend fun avoirYanoteParId(id: Int): Yanote? {
        return dao.avoirYanoteParId(id)
    }

    override suspend fun ajouterYanote(yanote: Yanote) {
        dao.ajouteYanote(yanote)
    }

    override suspend fun supprimerYanote(yanote: Yanote) {
        dao.supprimerYanote(yanote)
    }
}