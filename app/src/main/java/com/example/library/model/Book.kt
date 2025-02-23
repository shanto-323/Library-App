package com.example.library.model

data class Book(
    val AvailableCopies: Int,
    val CreatedAt: String,
    val ID: Int,
    val ISBN: String,
    val PublishedYear: Int,
    val Title: String,
    val TotalCopies: Int
)