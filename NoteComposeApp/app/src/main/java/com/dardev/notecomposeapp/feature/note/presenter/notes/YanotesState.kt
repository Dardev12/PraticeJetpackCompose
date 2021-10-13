package com.dardev.notecomposeapp.feature.note.presenter.notes

import com.dardev.notecomposeapp.feature.note.domain.model.Yanote
import com.dardev.notecomposeapp.feature.note.domain.util.OrderType
import com.dardev.notecomposeapp.feature.note.domain.util.YanoteOrder

data class YanotesState(
    val yanotes: List<Yanote> = emptyList(),
    val yanoteOrder: YanoteOrder = YanoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible:Boolean = false
)
