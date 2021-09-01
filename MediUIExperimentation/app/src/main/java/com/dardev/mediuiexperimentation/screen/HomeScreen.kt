package com.dardev.mediuiexperimentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dardev.mediuiexperimentation.R
import com.dardev.mediuiexperimentation.model.BottomItem
import com.dardev.mediuiexperimentation.model.Feature
import com.dardev.mediuiexperimentation.ui.materialdesign.UIKit
import com.dardev.mediuiexperimentation.ui.theme.*

class HomeScreen {
    var homeui=UIKit()

    @ExperimentalFoundationApi
    @Composable
    fun HomePatron(){
        Box(
            modifier= Modifier
                .background(DeepBlue)
                .fillMaxSize()
        ){
            Column {
                homeui.GreetingSelection()
                homeui.ChipSection(chips = listOf("Doux sommeil","Insomnie","Dépression"))
                homeui.CurrentMeditation()
                homeui.FeatureSection(features = listOf(
                    Feature(
                        title = "Meditation dodo",
                        R.drawable.ic_bubble,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tempeto",
                        R.drawable.ic_headphone,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Danse avec les Loups",
                        R.drawable.ic_home,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Meditation dodo",
                        R.drawable.ic_moon,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Meditation dodo",
                        R.drawable.ic_bubble,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                ))

            }
            homeui.BottomMenu(items = listOf(
                BottomItem(
                    title = "Home",
                    iconId = R.drawable.ic_home,
                ),
                BottomItem(
                    title = "Meditate",
                    iconId = R.drawable.ic_bubble,
                ),
                BottomItem(
                    title = "Sleep",
                    iconId = R.drawable.ic_moon,
                ),
                BottomItem(
                    title = "Musique",
                    iconId = R.drawable.ic_music,
                ),
                BottomItem(
                    title = "Profil",
                    iconId = R.drawable.ic_profile,
                ),
            ),modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}