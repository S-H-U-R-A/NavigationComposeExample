package com.sergio.rodriguez.examplenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sergio.rodriguez.examplenavigation.navigation.Screen1
import com.sergio.rodriguez.examplenavigation.navigation.Screen2
import com.sergio.rodriguez.examplenavigation.navigation.Screen3
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
                        startDestination = "pantalla1"
                    ){
                        composable(
                            route = "pantalla1"
                        ){
                            Screen1(){
                                navHostController.navigate(route = "pantalla2")
                            }
                        }
                        composable(
                            route = "pantalla2"
                        ){
                            Screen2(){
                                navHostController.navigate(route = "pantalla3")
                            }
                        }
                        composable(
                            route = "pantalla3"
                        ){
                            Screen3(){
                                navHostController.navigate(route = "pantalla1"){
                                    this.popUpTo(route= "pantalla1"){
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
