package com.dardev.notecomposeapp.feature.note.presenter.notes

import com.dardev.notecomposeapp.feature.note.domain.model.Yanote
import com.dardev.notecomposeapp.feature.note.domain.util.YanoteOrder

sealed class YanotesEvent{
    data class Order(val yanoteOrder: YanoteOrder): YanotesEvent()
    data class SupprimerYanote(val yanote: Yanote): YanotesEvent()
    object RestoreYanote:YanotesEvent()
    object ToggleOrderSection:YanotesEvent()
}
