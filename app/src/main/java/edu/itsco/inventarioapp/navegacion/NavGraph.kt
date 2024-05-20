package edu.itsco.inventarioapp.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import edu.itsco.inventarioapp.pantallas.HomeScreen
import edu.itsco.inventarioapp.pantallas.NuevoProductoScreen

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Pantallas.Home.url )
    {
        composable(route = Pantallas.Home.url){
            HomeScreen(
                navController = navController
            )
        }
        composable(route = Pantallas.NuevoProducto.url){
            NuevoProductoScreen(
                navController = navController
            )
        }
    }

}