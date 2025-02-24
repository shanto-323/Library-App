package com.example.library.domain.repository

interface Repository {
    suspend fun getAllBooks()
    suspend fun getAllStudents()
    suspend fun getAllBorrowedBooks()
}