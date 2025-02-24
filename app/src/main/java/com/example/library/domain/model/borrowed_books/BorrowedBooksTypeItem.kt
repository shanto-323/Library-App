package com.example.library.domain.model.borrowed_books

import com.example.library.domain.model.books.Book
import com.example.library.domain.model.student.Student

data class BorrowedBooksTypeItem(
    val Book: Book,
    val BookISBN: String,
    val ID: Int,
    val ReturnAt: String,
    val Returned: Boolean,
    val Student: Student,
    val StudentID: Int,
    val TakenAt: String
)