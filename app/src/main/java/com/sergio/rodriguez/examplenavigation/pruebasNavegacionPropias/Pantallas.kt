package com.sergio.rodriguez.examplenavigation.pruebasNavegacionPropias

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun Pantalla1(
    modifier: Modifier = Modifier,
    onNavigation: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Cyan),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Pantalla 1",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.
            clickable {
                onNavigation()
            }
        )
    }
}

@Composable
fun Pantalla2(
    modifier: Modifier = Modifier,
    onNavigation: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Green),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Pantalla 2",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.
            clickable {
                onNavigation()
            }
        )
    }
}

@Composable
fun Pantalla3(
    modifier: Modifier = Modifier,
    onNavigation: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Magenta),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Pantalla 3",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.
            clickable {
                onNavigation()
            }
        )
    }
}

@Composable
fun Pantalla4(
    modifier: Modifier = Modifier,
    name: String?,
    onNavigation: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Yellow),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Pantalla 4 ${name ?: "NO tendo" }",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.
            clickable {
                onNavigation()
            }
        )
    }
}

@Composable
fun Pantalla5(
    modifier: Modifier = Modifier,
    onNavigation: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Gray),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Pantalla 5",
            textAlign = TextAlign.Center,
            modifier = Modifier.
            clickable {
                onNavigation()
            }
        )
    }
}


@Composable
fun Pantalla1AnidadaLogin(
    modifier: Modifier = Modifier,
    onNavigation: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Pantalla 1 Anidada a partir del subgrafo LOGIN",
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.
            clickable {
                onNavigation()
            }
        )
    }
}

@Composable
fun Pantalla2AnidadaRegister(
    modifier: Modifier = Modifier,
    onNavigation: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Pantalla 2 Anidada a partir del subgrafo REGISTER",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.
            clickable {
                onNavigation()
            }
        )
    }
}

@Composable
fun Pantalla3AnidadaForgotPassword(
    modifier: Modifier = Modifier,
    onNavigation: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Pantalla 3 Anidada a partir del subgrafo FORGOT PASSWORD",
            color = Color.Green,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.
            clickable {
                onNavigation()
            }
        )
    }
}