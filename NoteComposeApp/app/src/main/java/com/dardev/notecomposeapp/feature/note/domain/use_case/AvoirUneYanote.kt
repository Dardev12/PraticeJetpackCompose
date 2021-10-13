package com.dardev.notecomposeapp.feature.note.domain.use_case

import com.dardev.notecomposeapp.feature.note.domain.model.Yanote
import com.dardev.notecomposeapp.feature.note.domain.repository.YanoteRepository

class AvoirUneYanote(
    private val repository: YanoteRepository
) {
    suspend operator fun invoke(id:Int): Yanote? {
        return repository.avoirYanoteParId(id)
    }
}