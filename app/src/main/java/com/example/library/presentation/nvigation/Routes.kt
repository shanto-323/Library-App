package com.example.library.presentation.nvigation

sealed class Routes(val route: String) {
    data object HomeScreen : Routes("home_screen")
    data object StudentScreen : Routes("student_screen")
    data object BookScreen : Routes("book_screen")
    data object BorrowedBookScreen : Routes("borrowed_book_screen")
}