package com.example.library.presentation.nvigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.library.presentation.BookScreen
import com.example.library.presentation.BorrowedBookScreen
import com.example.library.presentation.HomeScreen
import com.example.library.presentation.StudentScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .systemBarsPadding()
    ) {
        NavHost(navController = navController, startDestination = Routes.HomeScreen.route) {
            composable(Routes.HomeScreen.route) {
                HomeScreen(
                    navController = navController
                )
            }
            composable(Routes.BookScreen.route) {
                BookScreen(
                    navController = navController
                )
            }
            composable(Routes.StudentScreen.route) {
                StudentScreen(
                    navController = navController
                )
            }
            composable(Routes.BorrowedBookScreen.route) {
                BorrowedBookScreen(
                    navController = navController
                )
            }
        }

    }
}