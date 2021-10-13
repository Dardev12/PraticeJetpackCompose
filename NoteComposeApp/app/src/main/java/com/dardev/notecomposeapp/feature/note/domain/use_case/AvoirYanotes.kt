package com.dardev.notecomposeapp.feature.note.domain.use_case

import com.dardev.notecomposeapp.feature.note.domain.model.Yanote
import com.dardev.notecomposeapp.feature.note.domain.repository.YanoteRepository
import com.dardev.notecomposeapp.feature.note.domain.util.OrderType
import com.dardev.notecomposeapp.feature.note.domain.util.YanoteOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AvoirYanotes(
    private val repository: YanoteRepository
) {

    operator fun invoke(
        yanoteOrder: YanoteOrder = YanoteOrder.Date(OrderType.Descending)
    ):Flow<List<Yanote>>{

        return repository.avoirYanotes().map { yanotes ->
            when(yanoteOrder.orderType){
                is OrderType.Ascending -> {
                    when(yanoteOrder){
                        is YanoteOrder.Title -> yanotes.sortedBy { it.title.lowercase() }
                        is YanoteOrder.Date -> yanotes.sortedBy { it.timestamp }
                        is YanoteOrder.Color -> yanotes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(yanoteOrder){
                        is YanoteOrder.Title -> yanotes.sortedByDescending { it.title.lowercase() }
                        is YanoteOrder.Date -> yanotes.sortedByDescending { it.timestamp }
                        is YanoteOrder.Color -> yanotes.sortedByDescending { it.color }
                    }
                }
            }
        }

    }

}