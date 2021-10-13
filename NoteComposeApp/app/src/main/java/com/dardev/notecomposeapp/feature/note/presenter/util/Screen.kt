package com.dardev.notecomposeapp.feature.note.presenter.util

sealed class Screen(val route:String){
    object YanoteScreen:Screen("yanotes_screen")
    object AjoutEditYanoteScreen:Screen("ajout_edit_yanote_screen")
}
