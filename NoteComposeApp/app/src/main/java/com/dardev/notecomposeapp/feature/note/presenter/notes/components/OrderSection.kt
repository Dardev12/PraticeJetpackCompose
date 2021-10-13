package com.dardev.notecomposeapp.feature.note.presenter.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dardev.notecomposeapp.feature.note.domain.util.OrderType
import com.dardev.notecomposeapp.feature.note.domain.util.YanoteOrder

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    yanoteOrder: YanoteOrder = YanoteOrder.Date(OrderType.Descending),
    onOrderChange: (YanoteOrder) -> Unit
){
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Titre",
                selected = yanoteOrder is YanoteOrder.Title,
                onSelect = { onOrderChange(YanoteOrder.Title(yanoteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = yanoteOrder is YanoteOrder.Date,
                onSelect = { onOrderChange(YanoteOrder.Date(yanoteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Couleur",
                selected = yanoteOrder is YanoteOrder.Color,
                onSelect = { onOrderChange(YanoteOrder.Color(yanoteOrder.orderType)) }
            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            DefaultRadioButton(
                text = "Plus Haute",
                selected = yanoteOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(yanoteOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Plus Basse",
                selected = yanoteOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(yanoteOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}