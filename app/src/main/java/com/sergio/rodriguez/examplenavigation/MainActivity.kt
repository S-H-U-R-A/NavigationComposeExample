package com.sergio.rodriguez.examplenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sergio.rodriguez.examplenavigation.navigation.Routes
import com.sergio.rodriguez.examplenavigation.navigation.Routes.*
import com.sergio.rodriguez.examplenavigation.navigation.Screen1
import com.sergio.rodriguez.examplenavigation.navigation.Screen2
import com.sergio.rodriguez.examplenavigation.navigation.Screen3
import com.sergio.rodriguez.examplenavigation.navigation.Screen4
import com.sergio.rodriguez.examplenavigation.ui.theme.ExampleNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController: NavHostController = rememberNavController()

                    NavHost(
                        navController = navHostController,
                        startDestination = Pantalla1.route
                    ){
                        composable(
                            route = Pantalla1.route
                        ){
                            Screen1(){
                                navHostController.navigate(route = Pantalla2.route)
                            }
                        }
                        composable(
                            route = Pantalla2.route
                        ){
                            Screen2(){
                                navHostController.navigate(route = Pantalla3.route)
                            }
                        }
                        composable(
                            route = Pantalla3.route
                        ){
                            Screen3(){
                                navHostController.navigate(route = "Pantalla4/Sergio"){
                                    this.popUpTo(route= Pantalla4.route){
                                        this.inclusive = false
                                    }
                                }
                            }
                        }
                        composable(
                            route = Pantalla4.route
                        ){navBackStackEntry: NavBackStackEntry ->
                            val argument = navBackStackEntry.arguments?.getString("name") ?: "Sin Nombre"
                            Screen4(
                                name = argument
                            ){
                                navHostController.navigate(route = Pantalla1.route){
                                    this.popUpTo(route= Pantalla1.route){
                                        this.inclusive = true
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}
