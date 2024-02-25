package com.example.composeoreilly.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeoreilly.screens.details.DetailsScreen
import com.example.composeoreilly.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {

        composable(route = MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(
            route = MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {
                type = NavType.StringType })
        ) {backStackEntry ->

            DetailsScreen(navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}