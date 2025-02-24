package com.example.library.data.network

import com.example.library.domain.model.books.BookType
import com.example.library.domain.model.borrowed_books.BorrowedBooksType
import com.example.library.domain.model.student.StudentType
import retrofit2.http.GET

interface ApiService {
    @GET("user/get/all")
    suspend fun getALlStudent(): StudentType

    @GET("book/get/all")
    suspend fun getALlBooks(): BookType

    @GET("borrowed-books/get/all")
    suspend fun getALlBorrowedBooks(): BorrowedBooksType
}
