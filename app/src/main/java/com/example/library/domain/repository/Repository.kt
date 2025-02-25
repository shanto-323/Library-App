package com.example.library.domain.repository

import com.example.library.domain.model.BorrowedBook
import com.example.library.domain.model.books.Book
import com.example.library.domain.model.borrowed_books.BorrowedBooksTypeItem
import com.example.library.domain.model.student.Student

interface Repository {
    suspend fun getAllBooks(): List<Book>
    suspend fun getAllStudents(): List<Student>
    suspend fun getAllBorrowedBooks(): List<BorrowedBooksTypeItem>
}