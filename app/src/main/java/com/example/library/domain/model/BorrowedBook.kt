package com.example.library.domain.model

import com.example.library.domain.model.books.Book
import com.example.library.domain.model.student.Student

data class BorrowedBook(
    val Book: Book,
    val BookISBN: String,
    val ID: Int,
    val ReturnAt: String,
    val Returned: Boolean,
    val Student: Student,
    val StudentID: Int,
    val TakenAt: String
)