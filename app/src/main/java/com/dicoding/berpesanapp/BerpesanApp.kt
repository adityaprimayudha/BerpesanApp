package com.dicoding.berpesanapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dicoding.berpesanapp.ui.navigation.Screen

@Composable
fun BerpesanApp(
    modifier: Modifier = Modifier,
    navController : NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(modifier = modifier) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.SignIn.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.SignIn.route) {

            }
            composable(Screen.SignUp.route) {

            }
            composable(Screen.Home.route) {

            }
            composable(Screen.Chat.route) {

            }
            composable(Screen.Account.route) {

            }
        }
    }
}