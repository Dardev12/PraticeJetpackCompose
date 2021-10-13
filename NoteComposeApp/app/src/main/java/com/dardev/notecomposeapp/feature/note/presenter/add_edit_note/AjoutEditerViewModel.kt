package com.dardev.notecomposeapp.feature.note.presenter.add_edit_note

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dardev.notecomposeapp.feature.note.domain.model.InvalidYanoteException
import com.dardev.notecomposeapp.feature.note.domain.model.Yanote
import com.dardev.notecomposeapp.feature.note.domain.use_case.YanoteUseCases
import com.dardev.notecomposeapp.feature.note.presenter.notes.YanotesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AjoutEditerViewModel @Inject constructor(
    private val yanoteUseCases: YanoteUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _noteTitle = mutableStateOf(YanoteTextFieldState(
        hint = "Entrer un titre..."
    ))
    val noteTitle: State<YanoteTextFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(YanoteTextFieldState(
        hint = "Entrer du contenue"
    ))
    val noteContent: State<YanoteTextFieldState> = _noteContent

    private val _noteColor = mutableStateOf(Yanote.yanoteColors.random().toArgb())
    val noteColor: State<Int> = _noteColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentYanoteId:Int? = null

    init {
        savedStateHandle.get<Int>("yanoteId")?.let { yanoteId ->
            if (yanoteId != -1){
                viewModelScope.launch {
                    yanoteUseCases.avoirUnYanote(yanoteId)?.also{ yanote->
                        currentYanoteId = yanote.id
                        _noteTitle.value = noteTitle.value.copy(
                            text = yanote.title,
                            isHintVisible = false
                        )
                        _noteContent.value = noteContent.value.copy(
                            text = yanote.content,
                            isHintVisible = false
                        )
                        _noteColor.value = noteColor.value
                    }
                }
            }
        }
    }

    fun onEvent(event:AjoutEditYanoteEvent){
        when(event){
            is AjoutEditYanoteEvent.EntererTitre -> {
                _noteTitle.value = noteTitle.value.copy(
                    text = event.value
                )
            }
            is AjoutEditYanoteEvent.ChangerTitreFocus -> {
                _noteTitle.value = noteTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteTitle.value.text.isBlank()
                )
            }
            is AjoutEditYanoteEvent.EntererContenue -> {
                _noteContent.value = noteContent.value.copy(
                    text = event.value
                )
            }
            is AjoutEditYanoteEvent.ChangerContenueFocus -> {
                _noteContent.value = noteContent.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteContent.value.text.isBlank()
                )
            }
            is AjoutEditYanoteEvent.ChangerCouleur -> {
                _noteColor.value = event.color
            }
            is AjoutEditYanoteEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        yanoteUseCases.ajouterYanote(
                            Yanote(
                                title = noteTitle.value.text,
                                content = noteContent.value.text,
                                timestamp = System.currentTimeMillis(),
                                color = noteColor.value,
                                id = currentYanoteId
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveYanote)
                    }catch (e:InvalidYanoteException){
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Ne peut pas sauvegarder"
                            )
                        )
                    }
                }
            }

        }
    }

    sealed class UiEvent{
        data class ShowSnackbar(val message:String):UiEvent()
        object SaveYanote:UiEvent()
    }
}