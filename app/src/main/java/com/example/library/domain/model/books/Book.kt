package com.example.library.domain.model.books

data class Book(
    val Authors: List<Author>? = null,
    val AvailableCopies: Int,
    val CreatedAt: String,
    val Genres: List<Genre>,
    val ID: Int,
    val ISBN: String,
    val PublishedYear: Int,
    val Title: String,
    val TotalCopies: Int
)