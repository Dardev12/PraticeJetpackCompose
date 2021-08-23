package com.dardev.experimentationone

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dardev.experimentationone.animation.DiveToContent
import com.dardev.experimentationone.functioniality.VerifierConnexion
import com.dardev.experimentationone.model.BottomNavItem
import kotlinx.coroutines.delay
import com.dardev.experimentationone.ui.theme.Shapes





@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "anime"){
        composable("main"){
            HomeScreen()
        }
        composable("tchat"){
            TchatScreen()
        }
        composable("anime"){
            AnimeSplashScreen(navController = navController)
        }
        composable("login"){
            LoginScreen(navController = navController)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(
    items:List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier=Modifier,
    onItemClick:(BottomNavItem)->Unit
){
    val backStackEntry=navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item->
            val selected= item.route==backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = item.route==navController.currentDestination?.route,
                onClick = { onItemClick(item) },
                selectedContentColor=Color.Yellow,
                unselectedContentColor=Color.Gray,
                icon={
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

@Composable
fun HomeScreen(){
    //Cardinit
    val painter = painterResource(id=R.drawable.web_hi_res_512)
    val description="Kitana qui like"
    val title = " Kitana aime jetpack Kompose"

    Box(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp)
    ) {

        CardImage(
            painter = painter,
            contentDescription = description,
            title = title
        )

    }
}

@Composable
fun TchatScreen(){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Text(text = "TCHAT")
    }
}

@Composable
fun AnimeSplashScreen(navController: NavController){
    val scale=remember{
        Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate(route = "login")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_yanote),
            contentDescription = "TestLogo",
            modifier = Modifier
                .scale(scale.value)
        )
    }
}


@Composable
fun LoginScreen(navController: NavController){
    /*Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        TextField(modifier = Modifier.background(Color.Green),value = "username", onValueChange = String )
        Button(onClick = { VerifierConnexion("","") }) {
            
        }
    }*/

    Column(modifier = Modifier.padding(16.dp)) {
        Headertext()
        Spacer(modifier = Modifier.height(128.dp))
        UsernameChamp()
        Spacer(modifier = Modifier.height(4.dp))
        PasswordChamp()
        Spacer(modifier = Modifier.height(69.dp))
        BoutonConnexion(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        BoutonFBConnexion()

    }
}

@Composable
private fun Headertext(){
    Text(text = "Bienvenue",fontWeight = FontWeight.Bold,fontSize=32.sp)
    Text(text = "Sign in to continue",fontWeight = FontWeight.Bold,color = Color.LightGray)
}

@Composable
private fun UsernameChamp(){
    var username by remember{ mutableStateOf("")}
    
    OutlinedTextField(
        value = username,
        onValueChange = {username=it},
        label={Text(text = "Username")},
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun PasswordChamp(){
    var password by remember{ mutableStateOf("")}

    OutlinedTextField(
        value = password,
        onValueChange = {password=it},
        label={Text(text = "password")},
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun BoutonConnexion(navController: NavController){
    Button(
        onClick = { VerifierConnexion(username = "Darren",password = "1234",navController)},
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp,horizontal = 16.dp),
        shape=Shapes.large
    ) {
            Text(text = "Connexion")
    }
}

@Composable
private fun BoutonFBConnexion(){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 1.dp,horizontal = 1.dp),
        shape=Shapes.large,
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor=Color.LightGray)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.ic_icons8_facebook),contentDescription = "",modifier = Modifier.size(50.dp))
            Text(text = " Connexion via Facebook ",color = Color.Blue)
        }
    }
}