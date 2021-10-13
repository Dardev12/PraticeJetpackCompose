package com.dardev.notecomposeapp.feature.note.presenter.add_edit_note

import androidx.compose.ui.focus.FocusState

sealed class AjoutEditYanoteEvent {
    data class EntererTitre(val value: String) : AjoutEditYanoteEvent()
    data class ChangerTitreFocus(val focusState: FocusState) : AjoutEditYanoteEvent()
    data class EntererContenue(val value: String) : AjoutEditYanoteEvent()
    data class ChangerContenueFocus(val focusState: FocusState) : AjoutEditYanoteEvent()
    data class ChangerCouleur(val color: Int) : AjoutEditYanoteEvent()
    object SaveNote : AjoutEditYanoteEvent()
}
