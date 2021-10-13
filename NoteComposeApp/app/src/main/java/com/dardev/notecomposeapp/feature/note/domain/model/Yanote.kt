package com.dardev.notecomposeapp.feature.note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dardev.notecomposeapp.ui.theme.*

@Entity
data class Yanote(
    val title:String,
    val content:String,
    val timestamp:Long,
    val color:Int,
    @PrimaryKey val id: Int? = null
){
    companion object{
        val yanoteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidYanoteException(message:String):Exception(message)
