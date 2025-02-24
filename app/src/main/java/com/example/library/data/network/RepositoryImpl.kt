package com.example.library.data.network

import com.example.library.domain.repository.Repository

class RepositoryImpl(
    private val apiService: ApiService
) : Repository {
    override suspend fun getAllBooks() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllStudents() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllBorrowedBooks() {
        TODO("Not yet implemented")
    }
}