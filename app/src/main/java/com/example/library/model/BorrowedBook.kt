package com.example.library.model

data class BorrowedBook(
    val BookISBN: String,
    val ID: Int,
    val ReturnAt: String,
    val Returned: Boolean,
    val StudentID: Int,
    val TakenAt: String
)