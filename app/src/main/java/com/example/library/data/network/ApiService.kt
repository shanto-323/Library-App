package com.example.library.data.network

import com.example.library.domain.model.books.BookType
import com.example.library.domain.model.borrowed_books.BorrowedBooksType
import com.example.library.domain.model.student.StudentType
import retrofit2.http.GET

interface ApiService {
    @GET("user/all")
    suspend fun getALlStudent(): StudentType

    @GET("book/all")
    suspend fun getALlBooks(): BookType

    @GET("borrowed-books/all")
    suspend fun getALlBorrowedBooks(): BorrowedBooksType
}
