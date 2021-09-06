package com.dardev.onlyclone.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dardev.onlyclone.R
import com.dardev.onlyclone.model.ImageAvecTexte
import com.dardev.onlyclone.navigate.RouteNav

class ProfilScreen(navController: NavController) {

    var navigation = navController

    @ExperimentalFoundationApi
    @Composable
    fun PatronProfil(){
        var selectedTabIndex by remember{
            mutableStateOf(0)
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)) {

            Spacer(modifier = Modifier.height(4.dp))

            TopBar(
                name = "trish_una",
                modifier = Modifier.padding(10.dp),
            )

            Spacer(modifier = Modifier.height(4.dp))

            PofilInfo()
            Spacer(modifier = Modifier.height(25.dp))
            ProfilBoutton(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(25.dp))
            ProfilStorySection(
                storyArchive = listOf(
                    ImageAvecTexte(
                        image = painterResource(id = R.drawable.ic_baseline_add_circle_24),
                        text = "Ajouter..."
                    ),
                    ImageAvecTexte(
                      image = painterResource(id = R.drawable.youtube),
                      text = "Youtube"
                    ),
                    ImageAvecTexte(
                        image = painterResource(id = R.drawable.qa),
                        text = "Q&A"
                    ),
                    ImageAvecTexte(
                        image = painterResource(id = R.drawable.discord),
                        text = "Discord"
                    ),
                    ImageAvecTexte(
                        image = painterResource(id = R.drawable.telegram),
                        text = "Telgram"
                    ),
                    ImageAvecTexte(
                        image = painterResource(id = R.drawable.spicy_girl),
                        text = "Spicy Girl"
                    ),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 1.dp)

            )
            Spacer(modifier = Modifier.height(10.dp))
            ProfilTabView(
                imageAvecTexte = listOf(
                    ImageAvecTexte(
                        image = painterResource(id = R.drawable.ic_grid),
                        text ="Posts"
                    ),
                    ImageAvecTexte(
                        image = painterResource(id = R.drawable.ic_reels),
                        text ="Reels"
                    ),
                    ImageAvecTexte(
                        image = painterResource(id = R.drawable.ic_igtv),
                        text ="IGTV"
                    ),
                    ImageAvecTexte(
                        image = painterResource(id = R.drawable.profile),
                        text ="Profile"
                    ),

                ),
                
            ){
                selectedTabIndex=it
            }
            when(selectedTabIndex){
                0->ProfilPost(
                    posts = listOf(
                        painterResource(id = R.drawable.spicy_girl),
                        painterResource(id = R.drawable.trish_una_profil),
                        painterResource(id = R.drawable.ggiorno_giovanna),
                        painterResource(id = R.drawable.spicy_girl2),
                        painterResource(id = R.drawable.jojo_part5),
                        painterResource(id = R.drawable.ic_launchofclone_foreground)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
        }
    }

    @Composable
    fun TopBar(
        name:String,
        modifier: Modifier=Modifier
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { navigation.navigate(RouteNav.main_route) }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp),


                    )
            }
            Text(
                text=name,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_bell),
                contentDescription = "Bell",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                painter =painterResource(id = R.drawable.ic_dotmenu),
                contentDescription = "menudot",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )

        }
    }

    @Composable
    fun PofilIconRound(
        image:Painter,
        modifier: Modifier=Modifier
    ){
        Image(
            painter = image,
            contentDescription = null,

            modifier = modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 3.dp,
                    color = Color.Blue,
                    shape = CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape)
        )

    }

    @Composable
    fun PofilInfo(
        modifier: Modifier=Modifier
    ){
        Column(modifier = Modifier.fillMaxWidth()) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ){
                PofilIconRound(
                    image = painterResource(id = R.drawable.trish_una_profil),
                    modifier = Modifier
                        .size(100.dp)
                        .weight(3f)
                )
                Spacer(modifier = Modifier.height(19.dp))
                PofilStatSection(modifier = Modifier.weight(9f))

            }
            ProfilDescription(
                displayNom="Stand User ",
                description= "Possède un Stand du nom de Spice Girl\n" +
                "Fille du Boss de Passione\n"+"BestGirl !!",
                url="https://www.youtube.com/watch?v=1ajlgvriyLY&t=238s",
                suiviPar=listOf("bruno_bucciarati","dio_brando"),
                otherCount= 10
            )

        }
    }

    @Composable
    fun PofilStatSection(modifier: Modifier=Modifier){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
        ) {
            PofilStat(nombreText = "601",text="Publications")
            PofilStat(nombreText = "150K",text="Abonnés")
            PofilStat(nombreText = "601",text="Abonnement")
        }
    }

    @Composable
    fun PofilStat(
        nombreText:String,
        text:String,
        modifier: Modifier=Modifier
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Text(
                text = nombreText,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = text)
        }

    }

    @Composable
    fun ProfilDescription(
        displayNom:String,
        description:String,
        url:String,
        suiviPar:List<String>,
        otherCount:Int
    ){
        val espaceLettre = 0.5.sp
        val grosseurLigne = 20.sp
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
        ) {
            Text(
                text = displayNom,
                fontWeight = FontWeight.Bold,
                letterSpacing = espaceLettre,
                lineHeight = grosseurLigne
            )
            Text(
                text = description,
                letterSpacing = espaceLettre,
                lineHeight = grosseurLigne
            )
            Text(
                text = url,
                color = Color(0xFF3D3D91),
                letterSpacing = espaceLettre,
                lineHeight = grosseurLigne
            )
            if (suiviPar.isNotEmpty()){
                Text(
                    text = buildAnnotatedString {
                          val boldStyle = SpanStyle(
                              color = Color.Black,
                              fontWeight = FontWeight.Bold,
                          )
                        append("Suivis par ")

                        suiviPar.forEachIndexed{index,name->
                            pushStyle(boldStyle)
                            append(name)
                            pop()
                            if(index<suiviPar.size-1){
                                append(", ")
                            }


                        }
                        if (otherCount>2){
                            append(" et ")
                            pushStyle(boldStyle)
                            append("$otherCount autres personnes sont abonnés ")
                        }
                    },

                    letterSpacing = espaceLettre,
                    lineHeight = grosseurLigne
                )
            }
        }

    }

    @Composable
    fun ProfilBoutton(
        modifier: Modifier=Modifier
    ){
        val minWidth=95.dp
        val height=30.dp
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
        ) {
            ProfilActionBoutton(
                text="Abonné(e)",
                icon=Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height)
            )

            ProfilActionBoutton(
                text="Message",
                modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height)
            )
            ProfilActionBoutton(
                text="Email",
                icon=Icons.Default.Email,
                modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height)
            )
            ProfilActionBoutton(
                icon=Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height)
            )
        }
    }

    @Composable
    fun ProfilActionBoutton(
        modifier: Modifier=Modifier,
        text: String? = null,
        icon: ImageVector? = null
    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(6.dp)
        ){
            if(text != null)
                Text(
                    text = text,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            
            if(icon != null){
                Icon(imageVector = icon , contentDescription = null,tint=Color.Black)
            }
        }

    }


    @Composable
    fun ProfilStorySection(
        modifier:Modifier = Modifier,
        storyArchive:List<ImageAvecTexte>
    ){
        LazyRow(modifier = modifier){
            items(storyArchive.size){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(end = 15.dp)
                ) {
                    PofilIconRound(
                        image = storyArchive[it].image,
                        modifier = Modifier.size(70.dp)
                    )
                    Text(
                        text = storyArchive[it].text,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )

                }
            }
        }


    }

    @Composable
    fun ProfilTabView(
        modifier: Modifier=Modifier,
        imageAvecTexte: List<ImageAvecTexte>,
        onTabSelected:(selectIndex:Int)->Unit
    ){
        var selectedTabIndex by remember {
            mutableStateOf(0)
        }
        val inactiveColor = Color(0xFF77777777)
        TabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color.Transparent,
            contentColor = Color.Black,
            modifier = modifier
        ) {
            imageAvecTexte.forEachIndexed { index, item->
                Tab(
                    selected= selectedTabIndex==index,
                    unselectedContentColor = inactiveColor,
                    onClick = {
                        selectedTabIndex=index
                        onTabSelected(index)
                    }
                ){
                    Icon(
                        painter = item.image,
                        contentDescription =item.text,
                        tint=if(selectedTabIndex==index) Color.Black else inactiveColor,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(20.dp)
                    )
                }
            }

        }
    }

    @ExperimentalFoundationApi
    @Composable
    fun ProfilPost(
        posts:List<Painter>,
        modifier: Modifier=Modifier
    ){
            LazyVerticalGrid(
                cells = GridCells.Fixed(3),
                modifier = Modifier.scale(1.0f)
            ){
                items(posts.size){
                    Image(
                        painter = posts[it],
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.aspectRatio(1f)
                    )
                }
            }
    }


    //Prev
    /*@ExperimentalFoundationApi
    @Preview
    @Composable
    fun PatronProfilPrev(){
        //PatronProfil()
    }*/
}
