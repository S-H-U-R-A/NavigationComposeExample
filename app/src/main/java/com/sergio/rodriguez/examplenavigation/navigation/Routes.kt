package com.sergio.rodriguez.examplenavigation.navigation


sealed class Routes(val route: String) {

    data object Pantalla1 : Routes(route= "Pantalla1")
    data object Pantalla2 : Routes(route= "Pantalla2")
    data object Pantalla3 : Routes(route= "Pantalla3")
    data object Pantalla4 : Routes(route= "Pantalla4/{id}/{age}/{name}"){ // De esta forma indicamos que esta ruta espera varios parámetros obligatorios
        fun sendArgumentToRoute(id: Int, age: Int, name: String): String {
            return "Pantalla4/$id/$age/$name"
        }
    }
    data object Pantalla5 : Routes(route= "Pantalla5?fullname={fullname}"){ // De esta forma indicamos que esta ruta espera un parámetro opcional
        fun sendArgumentToRoute(fullname: String): String {
            return "Pantalla5?fullname=$fullname"
        }
    }
}