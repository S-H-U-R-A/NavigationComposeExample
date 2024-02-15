package com.sergio.rodriguez.examplenavigation.pruebasNavegacionPropias

import androidx.annotation.StringRes
import com.sergio.rodriguez.examplenavigation.R

//RUTAS DEL GRAFO PRINCIPAL
sealed class PruebaRoutes(val route: String) {
    data object Pantalla1 : PruebaRoutes(route= "Pantalla1")
    data object Pantalla2 : PruebaRoutes(route= "Pantalla2")
    data object Pantalla3 : PruebaRoutes(route= "Pantalla3")
    data object Pantalla4 : PruebaRoutes(route= "Pantalla4/{name}"){
        fun sendArgumentToRoute(name: String): String {
            return "Pantalla4/$name"
        }
    }
    data object Pantalla5 : PruebaRoutes(route= "Pantalla5")
}

//RUTAS DEL GRAFO ANIDADO
sealed class RoutesNested(val route: String){

    data object RouteSubGraph: RoutesNested(route = "Auth") //IDENTIFICADOR DEL SUBGRAFO
    data object Pantalla1Anidada: RoutesNested(route = "Login")
    data object Pantalla2Anidada: RoutesNested(route = "Register")
    data object Pantalla3Anidada: RoutesNested(route = "ForgotPassword")
}

