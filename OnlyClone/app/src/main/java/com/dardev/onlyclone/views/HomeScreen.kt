package com.dardev.onlyclone.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dardev.onlyclone.R
import com.dardev.onlyclone.model.BottomNavItem
import com.dardev.onlyclone.model.StoryIcon
import com.dardev.onlyclone.navigate.RouteNav
import com.dardev.onlyclone.ui.theme.FocusElementColorN
import com.dardev.onlyclone.ui.theme.MainColorLight
import com.dardev.onlyclone.ui.theme.UiColorLight

class HomeScreen (navController: NavController){
    var navi = navController
    var profilScreen=ProfilScreen(navi)
    /*@Preview
    @Composable
    fun PatronHomePrev(){
        PatronHome()
    }*/

    @ExperimentalMaterialApi
    @Composable
    fun PatronHome(){
        Scaffold(
            topBar = {
                Surface(color = MainColorLight) {
                    TopBar(name = "OnlyClone",modifier = Modifier.padding(10.dp))
                }
            },
            bottomBar = {
                Surface(color = MainColorLight){
                    BotBar( navController = navi)
                }
            }
        ){
            Body(story = listOf(
                StoryIcon(
                  R.drawable.ggiorno_giovanna,
                    "giorno"
                ),
            ))
        }
    }



    @Composable
    fun Body(
        story:List<StoryIcon>
    ){
        var selectedStoryIndex by remember {
            mutableStateOf(0)
        }

        Column(modifier = Modifier.fillMaxWidth().fillMaxSize()) {
            LazyRow (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ){
                items(story.size){
                    val couleurBordure= if (selectedStoryIndex==it) FocusElementColorN else UiColorLight
                    Image(
                        painter = painterResource(id = story[it].image),
                        contentDescription = null,

                        modifier = Modifier
                            .aspectRatio(1f, matchHeightConstraintsFirst = true)
                            .border(
                                width = 3.dp,
                                color = couleurBordure,
                                shape = CircleShape
                            )
                            .padding(3.dp)
                            .clip(CircleShape)
                    )


                }
            }
        }
        /*items(chips.size){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                        .clickable {
                            selectedChipIndex = it
                        }
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            if (selectedChipIndex == it) ButtonBlue
                            else DarkerButtonBlue
                        )
                        .padding(15.dp)
                ){
                    Text(text=chips[it],color= TextWhite)
                }
            }*/


    }

    @Composable
    fun StorysCollection(){

    }

    @Composable
    fun TopBar(
        name:String,
        modifier: Modifier = Modifier
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text=name,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive
            )
            Spacer(modifier = Modifier.height(15.dp))

            Image(painter = painterResource(id = R.drawable.ic_red_lips),
                contentDescription = "Only Fan Clone Logo",
                modifier =Modifier.size(24.dp)
            )
        }


    }

    @ExperimentalMaterialApi
    @Composable
    fun BotBar(
        modifier: Modifier = Modifier,
        navController:NavController
    ){
        BotNavBar(
            items = listOf(
                BottomNavItem(
                    name="Main",
                    route = RouteNav.main_route,
                    icon= Icons.Default.Home
                ),

                BottomNavItem(
                    name="Tchat",
                    route = RouteNav.tchats_route,
                    icon= Icons.Default.Email
                ),
                BottomNavItem(
                    name="Profil",
                    route = RouteNav.profil_route,
                    icon= Icons.Default.AccountCircle
                ),
            ),
            navController = navController,
            onItemClick = {
                navController.navigate(it.route)
            },
        modifier = modifier
            )
    }

    @ExperimentalMaterialApi
    @Composable
    fun BotNavBar(
        items:List<BottomNavItem>,
        navController: NavController,
        modifier: Modifier=Modifier,
        onItemClick:(BottomNavItem)->Unit
    ){
        val backStackEntry=navController.currentBackStackEntryAsState()
        BottomNavigation(
            modifier = modifier,
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 5.dp
        ) {
            items.forEach { item->
                val selected = item.route==backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = item.route==navController.currentDestination?.route,
                    onClick = { navController?.navigate(route = item.route) },
                    selectedContentColor = MaterialTheme.colors.primaryVariant,
                    unselectedContentColor = MaterialTheme.colors.secondary,
                    icon = {
                        Column(horizontalAlignment = CenterHorizontally) {
                            if(item.badgeCount>0){
                                BadgeBox(
                                    badgeContent = {
                                        Text(text = item.badgeCount.toString())
                                    }
                                ) {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = item.name
                                    )
                                }
                            }else{
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }

                            if(selected){
                                Text(
                                    text=item.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 10.sp
                                )
                            }
                        }

                    }
                )

            }

        }
    }



}