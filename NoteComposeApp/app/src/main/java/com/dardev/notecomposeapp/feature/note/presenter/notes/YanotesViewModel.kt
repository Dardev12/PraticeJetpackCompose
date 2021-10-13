package com.dardev.notecomposeapp.feature.note.presenter.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dardev.notecomposeapp.feature.note.domain.model.Yanote
import com.dardev.notecomposeapp.feature.note.domain.use_case.YanoteUseCases
import com.dardev.notecomposeapp.feature.note.domain.util.OrderType
import com.dardev.notecomposeapp.feature.note.domain.util.YanoteOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YanotesViewModel @Inject constructor(
    private val yanoteUseCases: YanoteUseCases
):ViewModel() {

    private val _state = mutableStateOf<YanotesState>(YanotesState())
    val state: State<YanotesState> = _state

    private var recementSupprimerYanote: Yanote? = null

    private var getYanotesJob:Job? = null

    init {
        avoirLesYanotes(YanoteOrder.Date(OrderType.Descending))
    }


    fun onEvent(event: YanotesEvent){
        when(event){
            is YanotesEvent.Order ->{
                if(state.value.yanoteOrder::class == event.yanoteOrder::class &&
                        state.value.yanoteOrder.orderType == event.yanoteOrder.orderType
                ){
                    return
                }
                avoirLesYanotes(event.yanoteOrder)
            }
            is YanotesEvent.SupprimerYanote -> {
                viewModelScope.launch {
                    yanoteUseCases.supprimerYanote(event.yanote)
                    recementSupprimerYanote = event.yanote
                }
            }
            is YanotesEvent.RestoreYanote -> {
                viewModelScope.launch{
                    yanoteUseCases.ajouterYanote(recementSupprimerYanote ?: return@launch)
                    recementSupprimerYanote = null
                }
            }
            is YanotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun avoirLesYanotes(yanoteOrder: YanoteOrder){
        getYanotesJob?.cancel()
        getYanotesJob = yanoteUseCases.avoirYanotes(yanoteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    yanotes = notes,
                    yanoteOrder = yanoteOrder
                )
            }
            .launchIn(viewModelScope)
    }

}