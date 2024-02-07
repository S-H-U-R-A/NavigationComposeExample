package com.sergio.rodriguez.examplenavigation.navigation


sealed class Routes(val route: String) {
    data object Pantalla1 : Routes(route = "Pantalla1")
    data object Pantalla2 : Routes(route = "Pantalla2")
    data object Pantalla3 : Routes(route = "Pantalla3")
}