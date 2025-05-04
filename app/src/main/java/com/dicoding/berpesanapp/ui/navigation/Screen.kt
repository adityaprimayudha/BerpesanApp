package com.dicoding.berpesanapp.ui.navigation

sealed class Screen(val route: String) {
    data object SignIn: Screen("signin")
    data object SignUp: Screen("signup")
    data object Home: Screen("home")
    data object Chat: Screen("chat")
    data object ChatDetail: Screen("chat/{chatId}") {
        fun createRoute(chatId: Int) = "chat/$chatId"
    }
    data object Account: Screen("account")
}