package com.example.testtsk.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.testtsk.R
import com.example.testtsk.store.MainStore
import com.example.testtsk.viewModels.JokeViewModel
import kotlinx.coroutines.MainScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JokeScreen(navController: NavController){
    val jokeViewModel: JokeViewModel = hiltViewModel()

    LaunchedEffect(UInt){
        jokeViewModel.getJoke()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary),
                title = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()) {
                        Text(
                            text = MainStore.joke,
                            maxLines = 1,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Start)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {navController.navigateUp()}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        },
        content = {innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                if (jokeViewModel.isLoadingJoke.value){
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.primary)
                            .fillMaxWidth()

                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .size(128.dp),
                            model = MainStore.jokeS.value.url,
                            contentDescription = "",
                            )
                        Column(modifier = Modifier
                            .fillMaxWidth()) {
//                            Text(
//                                modifier = Modifier
//                                    .padding(12.dp),
//                                text = MainStore.jokeS.value.id,
//                                color = Color.White,
//                                fontSize = 18.sp,
//                                fontWeight = FontWeight.W500
//                            )
                            Text(
                                modifier = Modifier
                                    .padding(12.dp),
                                text = MainStore.jokeS.value.value,
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.W500
                            )
                        }
                    }
                }

            }

//            if (jokeViewModel.isLoadingJoke.value){
//                Text(
//                    text = "sdfsdf",//+MainStore.jokeS.value.id,
//                    color = Color.Black,
//                    fontSize = 18.sp
//                )
//            }
        }
    )
}