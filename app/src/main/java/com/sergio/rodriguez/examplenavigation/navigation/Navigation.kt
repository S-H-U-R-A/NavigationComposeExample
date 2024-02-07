package com.sergio.rodriguez.examplenavigation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Screen1(
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
            text = "Ir a la pantalla 2",
            modifier = Modifier.
                clickable {
                    onNavigation()
                }
        )
    }
}

@Composable
fun Screen2(
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
            text = "Ir a la pantalla 3",
            modifier = Modifier.
            clickable {
                onNavigation()
            }
        )
    }
}

@Composable
fun Screen3(
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
            text = "Ir a la pantalla 4",
            modifier = Modifier.
            clickable {
                onNavigation()
            }
        )
    }
}

@Composable
fun Screen4(
    modifier: Modifier = Modifier,
    name: Int,
    onNavigation: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Gray),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = name.toString(),
            modifier = Modifier.
            clickable {
                onNavigation()
            }
        )
    }
}