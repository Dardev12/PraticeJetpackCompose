package com.dardev.notecomposeapp.feature.note.domain.use_case

import com.dardev.notecomposeapp.feature.note.domain.model.Yanote
import com.dardev.notecomposeapp.feature.note.domain.repository.YanoteRepository

class SupprimerYanote(
    private val repository: YanoteRepository
) {
    suspend operator fun invoke(yanote: Yanote){
        repository.supprimerYanote(yanote)
    }
}