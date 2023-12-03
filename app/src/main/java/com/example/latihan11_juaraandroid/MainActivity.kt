package com.example.latihan11_juaraandroid

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.latihan11_juaraandroid.ui.theme.Latihan11_juaraandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Latihan11_juaraandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SelectDisplayArtSpace()
                }
            }
        }
    }
}

@Composable
fun SelectDisplayArtSpace(){
    val config = LocalConfiguration.current
    when(config.orientation){
        Configuration.ORIENTATION_LANDSCAPE->{
            ArtSpaceDisplayLandscape()
        }

        else->{ ArtSpaceDisplayPotrait() }

    }
}

@Composable
fun ArtSpaceDisplayLandscape(){
    var imgFirst by remember {mutableStateOf(0)}
    var imgResource = when(imgFirst){
        0 -> R.drawable.monas
        1 -> R.drawable.kotatua
        2 -> R.drawable.tmi
        3 -> R.drawable.ancol
        else->R.drawable.monas
    }
    var contentDescriptionImg by remember { mutableStateOf(0) }
    val strResource = when(contentDescriptionImg){
        0->R.string.judul_monas
        1->R.string.judul_kotatua
        2->R.string.judul_tmi
        3->R.string.judul_ancol
        else->{R.string.judul_monas}
    }
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center){
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(0.36f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(10.dp))
            Surface(modifier = Modifier
                .fillMaxHeight(0.66f)
                .fillMaxWidth(1f)
                .border(
                    BorderStroke(4.dp, SolidColor(Color.White)),
                    RectangleShape
                )
                .shadow(16.dp, RectangleShape)
                .align(alignment = Alignment.CenterHorizontally),
                shape = RoundedCornerShape(6.dp),
                shadowElevation = 11.dp
            ) {
                artWorkImgFun(imgResource = imgResource, strResource = strResource )
            }
            Spacer(modifier = Modifier.height(21.dp))
            artWorkContentFun(strResource = strResource)
            Spacer(modifier = Modifier.height(21.dp))
        }
    }
    artWorkButtonFun(
        imgFirst = imgFirst,
        contentDescriptionImg = contentDescriptionImg,
        displayMinus1 = {
            imgFirst -= 1
            contentDescriptionImg -= 1
                        },
        displayEq3 = {
                     imgFirst = 3
            contentDescriptionImg = 3
        },
        displayPlus1 = {
                       imgFirst += 1
            contentDescriptionImg += 1
        },
        displayEq0 = {
            imgFirst = 0
            contentDescriptionImg = 0
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceDisplayPotrait() {
    var imgFirst by remember{mutableStateOf(0)}
    var contentDescriptionImg by remember{mutableStateOf(0)}

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "Wisata Palestina", fontWeight = FontWeight.Bold)
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
        )
    }
    ){
        innerPadding->
        Surface( modifier = Modifier.fillMaxSize().padding(innerPadding).background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background){

    var imgResource = when(imgFirst){
        0->R.drawable.monas
        1->R.drawable.kotatua
        2->R.drawable.tmi
        3->R.drawable.ancol

        else -> R.drawable.monas
    }

    var strResource = when(contentDescriptionImg){
        0->R.string.judul_monas
        1->R.string.judul_kotatua
        2->R.string.judul_tmi
        3->R.string.judul_ancol

        else->R.string.judul_monas
    }
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
    ){
        Spacer(modifier = Modifier.height(41.dp))
        Surface(modifier = Modifier
            .fillMaxHeight(0.66f)
            .fillMaxWidth(1f)
            .border(BorderStroke(3.dp, SolidColor(Color.White)), RectangleShape)
            .shadow(16.dp, RectangleShape)
            .align(alignment = Alignment.CenterHorizontally),
            shape = RoundedCornerShape(6.dp),
            shadowElevation = 11.dp
        ){
            artWorkImgFun(imgResource = imgResource, strResource = strResource)
        }
        Spacer(modifier = Modifier.height(61.dp))
        artWorkContentFun(strResource = strResource)
        Spacer(modifier = Modifier.height(21.dp))
    }

    artWorkButtonFun(
        imgFirst = imgFirst,
        contentDescriptionImg = contentDescriptionImg,
        displayMinus1 = {
            imgFirst -= 1
            contentDescriptionImg -= 1
        },
        displayEq3 = {
            imgFirst = 3
            contentDescriptionImg = 3
        },
        displayPlus1 = {
            imgFirst += 1
            contentDescriptionImg += 1
        },
        displayEq0 = {
            imgFirst = 0
            contentDescriptionImg = 0
        }
        )
        }
}
}

@Composable
fun artWorkImgFun(
    modifier: Modifier = Modifier,
   @DrawableRes imgResource: Int,
   @StringRes strResource: Int
){
    Image(
        painter = painterResource(imgResource),
        contentDescription = stringResource(strResource),
        contentScale = ContentScale.Crop,
        modifier = Modifier.padding(36.dp)
    )
}

@Composable
fun artWorkContentFun(
    modifier: Modifier = Modifier,
    @StringRes strResource: Int
    ){
    Surface(modifier = Modifier.fillMaxWidth(), color = Color(0xFFECEBF4)){
        Column(modifier = Modifier.padding(21.dp)){
            Text(
                text = stringResource(strResource),
                fontSize = 23.sp,
                fontStyle = FontStyle.Italic
                )
            Row(){
                Text(
                    text = stringResource(R.string.arsitek_monas),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "(".plus(
                        stringResource(R.string.tahun_monas).plus(")")
                    ),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun artWorkButtonFun(
    modifier: Modifier = Modifier,
    @DrawableRes imgFirst: Int,
   @StringRes contentDescriptionImg: Int,
    displayMinus1: (Int)->Unit,
    displayEq3: (Int)->Unit,
    displayPlus1: (Int)->Unit,
    displayEq0: (Int)->Unit
){
    Row(modifier = Modifier
        .padding(15.dp)
        .fillMaxHeight()
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom
        ){
        Button(onClick = {
            if(imgFirst != 0 && contentDescriptionImg != 0){
                displayMinus1(imgFirst)
            }else{
                displayEq3(imgFirst)
            }
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color(73,93,146)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.width(150.dp),
        ){
            Text(text = "Previous", color = Color.White)
        }
        Spacer(modifier =Modifier.weight(1f))
        Button(onClick = {
            if(imgFirst < 3 && contentDescriptionImg < 3){
                displayPlus1(imgFirst)

            }else if(imgFirst == 3 && contentDescriptionImg == 3){
                displayEq0(imgFirst)

            }
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color(73, 93, 146)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.width(150.dp)
        ){
            Text(text = "Next", color = Color.White)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Latihan11_juaraandroidTheme {
        SelectDisplayArtSpace()
    }
}