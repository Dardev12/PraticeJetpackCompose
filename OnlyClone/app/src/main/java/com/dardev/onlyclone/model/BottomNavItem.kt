package com.dardev.onlyclone.model

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    var name:String,
    var route:String,
    var icon:ImageVector,
    val badgeCount:Int=0
)
