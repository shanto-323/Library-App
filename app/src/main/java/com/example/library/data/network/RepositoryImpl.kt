package com.example.library.data.network

import com.example.library.domain.model.BorrowedBook
import com.example.library.domain.model.books.Book
import com.example.library.domain.model.borrowed_books.BorrowedBooksTypeItem
import com.example.library.domain.model.student.Student
import com.example.library.domain.repository.Repository

class RepositoryImpl(
    private val apiService: ApiService
) : Repository {
    override suspend fun getAllBooks(): List<Book> {
        return apiService.getALlBooks()
    }

    override suspend fun getAllStudents(): List<Student> {
        return apiService.getALlStudent()
    }

    override suspend fun getAllBorrowedBooks(): List<BorrowedBooksTypeItem> {
        return apiService.getALlBorrowedBooks()
    }
}