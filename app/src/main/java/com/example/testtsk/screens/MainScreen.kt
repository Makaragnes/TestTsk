package com.example.testtsk.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.testtsk.NavRoute
import com.example.testtsk.store.MainStore

@Composable
fun MainScreen(navController: NavController){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            item {
                Spacer(modifier = Modifier.padding(32.dp))
                Text(
                    modifier = Modifier
                        .padding(12.dp),
                    text = "Jokes",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500
                )
            }
            items(MainStore.listOfJokes){ t->
                Row(
                    modifier = Modifier
                        .padding(12.dp, 6.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .clickable {
                            MainStore.joke = t
                            navController.navigate(NavRoute.JokeScreen.route)
                        }
                        .background(MaterialTheme.colorScheme.primary)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(12.dp),
                        text = t,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500
                    )
                }
            }
            item{
                Spacer(modifier = Modifier.padding(16.dp))
            }
        }
    }

}