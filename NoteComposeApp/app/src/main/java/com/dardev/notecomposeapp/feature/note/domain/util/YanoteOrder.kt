package com.dardev.notecomposeapp.feature.note.domain.util

sealed class YanoteOrder(val orderType: OrderType){
    class Title(orderType: OrderType):YanoteOrder(orderType)
    class Date(orderType: OrderType):YanoteOrder(orderType)
    class Color(orderType: OrderType):YanoteOrder(orderType)

    fun copy(orderType: OrderType):YanoteOrder{
        return when(this) {
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            is Color -> Color(orderType)
        }
    }
}
