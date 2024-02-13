package com.sergio.rodriguez.examplenavigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.sergio.rodriguez.examplenavigation.pruebasNavegacionPropias.Pantalla1
import com.sergio.rodriguez.examplenavigation.pruebasNavegacionPropias.Pantalla1AnidadaLogin
import com.sergio.rodriguez.examplenavigation.pruebasNavegacionPropias.Pantalla2
import com.sergio.rodriguez.examplenavigation.pruebasNavegacionPropias.Pantalla2AnidadaRegister
import com.sergio.rodriguez.examplenavigation.pruebasNavegacionPropias.Pantalla3
import com.sergio.rodriguez.examplenavigation.pruebasNavegacionPropias.Pantalla3AnidadaForgotPassword
import com.sergio.rodriguez.examplenavigation.pruebasNavegacionPropias.Pantalla4
import com.sergio.rodriguez.examplenavigation.pruebasNavegacionPropias.PruebaRoutes
import com.sergio.rodriguez.examplenavigation.pruebasNavegacionPropias.RoutesNested
import com.sergio.rodriguez.examplenavigation.ui.theme.ExampleNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleNavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController: NavHostController = rememberNavController()

                    NavHost(
                        navController = navHostController,
                        startDestination = PruebaRoutes.Pantalla1.route
                    ){
                        this.composable(
                            route= PruebaRoutes.Pantalla1.route
                        ){
                            Pantalla1(){
                                navHostController.navigate(route = PruebaRoutes.Pantalla2.route){
                                    this.launchSingleTop = true
                                }
                            }
                        }

                        this.composable(
                            route= PruebaRoutes.Pantalla2.route
                        ){
                            Pantalla2() {
                                navHostController.navigate(route = PruebaRoutes.Pantalla3.route) {
                                    this.popUpTo(route = PruebaRoutes.Pantalla1.route) {
                                        this.inclusive = false
                                        this.saveState = true
                                    }
                                }
                            }
                        }

                        this.composable(
                            route= PruebaRoutes.Pantalla3.route
                        ){
                            Pantalla3(){
                                navHostController.navigate(
                                    deepLink= Uri.parse("myapptest.com://home/Darlyn A De Rodriguez")
                                )
                            }
                        }

                        this.composable(
                            route= PruebaRoutes.Pantalla4.route,
                            arguments= listOf(
                                navArgument(name= "name"){
                                    this.type= NavType.StringType
                                    this.defaultValue= "Darlyn"
                                }
                            ),
                            deepLinks = listOf(
                                navDeepLink {
                                    this.uriPattern= "myapptest.com://home/{name}"
                                    this.action= Intent.ACTION_VIEW //QUE QUEREMOS HACER CON ESTE DEEPLINK
                                }
                            )
                        ){ backStackEntry: NavBackStackEntry ->

                            val argument = backStackEntry.arguments?.getString("name")

                            Pantalla4(
                                name = argument
                            ){
                                navHostController.navigate(route = RoutesNested.RouteSubGraph.route){}
                            }
                        }

                        this.navigation(
                            startDestination = RoutesNested.Pantalla1Anidada.route,
                            route= RoutesNested.RouteSubGraph.route //Identificador/Nombre-Ruta del subgrafo
                        ){
                            this.composable(
                                route= RoutesNested.Pantalla1Anidada.route
                            ){
                                Pantalla1AnidadaLogin{
                                    navHostController.navigate(route= RoutesNested.Pantalla2Anidada.route)
                                }
                            }
                            this.composable(
                                route= RoutesNested.Pantalla2Anidada.route
                            ){
                                Pantalla2AnidadaRegister {
                                    navHostController.navigate(route= RoutesNested.Pantalla3Anidada.route)
                                }
                            }
                            this.composable(
                                route= RoutesNested.Pantalla3Anidada.route
                            ){
                                Pantalla3AnidadaForgotPassword {
                /*                    navHostController.navigate(route= RoutesNested.Pantalla1Anidada.route){//Volvemos a el destino inicial del subgrafo
                                        this.popUpTo(route= RoutesNested.RouteSubGraph.route){//Eliminando la navegación ocurrida en el subgrafo
                                            inclusive= true
                                        }
                                    }*/
/*                                    navHostController.navigate(route= PruebaRoutes.Pantalla1.route){//Volvemos a el destino inicial del grafo principal, En este caso si damos back volveremos a la navegación que hubieramos llevado antes de entrar en el subgrafo
                                        this.popUpTo(route= RoutesNested.RouteSubGraph.route){//Eliminando la navegación ocurrida en el subgrafo
                                            inclusive= true
                                        }
                                    }*/
                                    navHostController.navigate(route= PruebaRoutes.Pantalla1.route){//Volvemos a el destino inicial del grafo principal
                                        this.popUpTo(route= PruebaRoutes.Pantalla1.route){//Eliminando toda la navegación ocurrida
                                            inclusive= true
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
}

//NAVHOST PARA PRUEBAS ARISTIDES

/*
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
            navHostController.navigate(
                route = Pantalla4.sendArgumentToRoute(
                    id = 1,
                    age = 25,
                    name = "Sergio"
                )
            ){
                this.popUpTo(route= Pantalla4.sendArgumentToRoute(id = 1, age = 25, name = "Sergio")){
                    this.inclusive = false
                }
            }
        }
    }
    composable(
        route = Pantalla4.route,
        arguments = listOf(     // Se definen los argumentos que recibirá esta pantalla
            navArgument(name = "id"){
                this.type = NavType.IntType // En la definición del argumento especificamos el tipo
            },
            navArgument(name = "age"){
                this.type = NavType.IntType
            },
            navArgument(name = "name"){
                this.type = NavType.StringType
            }
        )
    ){navBackStackEntry: NavBackStackEntry ->

        val id = navBackStackEntry.arguments!!.getInt("id")
        val age = navBackStackEntry.arguments!!.getInt("age")
        val name = navBackStackEntry.arguments!!.getString("name")!!

        Screen4(
            id = id,
            age = age,
            name = name
        ){
            navHostController.navigate(route = Pantalla5.route */
/*Pantalla5.sendArgumentToRoute(fullname = "Sergio Rodriguez")*//*
){//Podemos o no enviar argumentos a la siguiente pantalla
                this.popUpTo(route= Pantalla5.sendArgumentToRoute(fullname = "Sergio Rodriguez")){
                    this.inclusive = false
                }
            }
        }
    }
    composable(
        route = Pantalla5.route,
        arguments = listOf( // Se definen los argumentos que recibirá esta pantalla
            navArgument(name = "fullname"){
                this.type = NavType.StringType
                this.defaultValue = "Pepe"
            }
        )
    ){navBackStackEntry: NavBackStackEntry ->

        val fullname = navBackStackEntry.arguments!!.getString("fullname")!!

        Screen5(
            fullname = fullname
        ){
            navHostController.navigate(route = Pantalla1.route){
                this.popUpTo(route= Pantalla1.route){
                    this.inclusive = true
                }
            }
        }
    }
}*/
