package com.example.testtsk

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testtsk.screens.JokeScreen
import com.example.testtsk.screens.MainScreen

sealed class NavRoute(val route: String) {
    object MainScreen: NavRoute("main_screen")
    object JokeScreen : NavRoute("joke_screen")
}

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.MainScreen.route,
        route = "root"
    ) {
        composable(NavRoute.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(NavRoute.JokeScreen.route) {
            JokeScreen(navController = navController)
        }
    }
}