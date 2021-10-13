package com.dardev.notecomposeapp.feature.note.domain.use_case

import com.dardev.notecomposeapp.feature.note.domain.model.InvalidYanoteException
import com.dardev.notecomposeapp.feature.note.domain.model.Yanote
import com.dardev.notecomposeapp.feature.note.domain.repository.YanoteRepository

class AjouterYanote(
    private val repository: YanoteRepository
) {

    @Throws(InvalidYanoteException::class)
    suspend operator fun invoke(yanote: Yanote){
        if (yanote.title.isBlank()){
            throw InvalidYanoteException("Veuillez Mettre un titre à la note")
        }
        if (yanote.content.isBlank()){
            throw InvalidYanoteException("Veuillez Mettre des information sur la note")
        }
        repository.ajouterYanote(yanote)
    }

}