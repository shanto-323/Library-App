package com.example.library.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.library.domain.model.books.Book
import com.example.library.domain.model.books.Author
import com.example.library.domain.model.books.Genre
import com.example.library.presentation.nvigation.Routes
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@Composable
fun BookScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .padding(5.dp)
                    .clickable(
                        onClick = {
                            navController.navigate(Routes.HomeScreen.route)
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(start = 0.dp, end = 5.dp, top = 5.dp, bottom = 5.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    supportingText = {
                        Row {
                            Text(
                                text = "SEARCH ",
                                fontSize = 12.sp
                            )
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                            )
                        }

                    },
                    shape = RoundedCornerShape(10.dp)
                )
            }

        }
        LazyColumn {
            items(books) { i ->
                BookCard(
                    book = i
                )
            }
        }

    }
}


@Composable
fun BookCard(
    book: Book = books[1]
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        Text(
            text = book.Title,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 14.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "YEAR: " + book.PublishedYear,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "ISBN: " + book.ISBN,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "DATE ADDED: " + extractDateTime(book.CreatedAt),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 8.sp,
            maxLines = 1
        )

        Spacer(modifier = Modifier.padding(2.dp))
        Divider(thickness = 2.dp)
        Spacer(modifier = Modifier.padding(5.dp))


        Text(
            text = "Total Copies: " + book.TotalCopies,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            maxLines = 1
        )
        Text(
            text = "Available Copies: " + book.AvailableCopies,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            maxLines = 1
        )

    }
}

val authors = listOf(
    Author(
        Name = "",
        Nationality = "",
        ID = 0,
        Books = "",
        BirthYear = 0,
        CreatedAt = ""
    )
)
val genres = listOf(
    Genre(
        ID = 0,
        Name = "",
        Books = ""
    )
)

val books = arrayOf(
    Book(
        AvailableCopies = 10,
        CreatedAt = "2025-02-22T04:35:01.652579+06:00",
        ID = 1,
        ISBN = "ISBN0000000001",
        PublishedYear = 1949,
        Title = "1984",
        TotalCopies = 10,
        Authors = authors,
        Genres = genres
    ),
    Book(
        AvailableCopies = 8,
        CreatedAt = "2025-02-22T04:35:01.652579+06:00",
        ID = 2,
        ISBN = "ISBN0000000002",
        PublishedYear = 1960,
        Title = "To Kill a Mockingbird",
        TotalCopies = 8,
        Authors = authors,
        Genres = genres
    ),
    Book(
        AvailableCopies = 12,
        CreatedAt = "2025-02-22T04:35:01.652579+06:00",
        ID = 3,
        ISBN = "ISBN0000000003",
        PublishedYear = 1925,
        Title = "The Great Gatsby",
        TotalCopies = 12,
        Authors = authors,
        Genres = genres
    ),
    Book(
        AvailableCopies = 15,
        CreatedAt = "2025-02-22T04:35:01.652579+06:00",
        ID = 4,
        ISBN = "ISBN0000000004",
        PublishedYear = 1813,
        Title = "Pride and Prejudice",
        TotalCopies = 15,
        Authors = authors,
        Genres = genres
    ),
    Book(
        AvailableCopies = 7,
        CreatedAt = "2025-02-22T04:35:01.652579+06:00",
        ID = 5,
        ISBN = "ISBN0000000005",
        PublishedYear = 1951,
        Title = "The Catcher in the Rye",
        TotalCopies = 7,
        Authors = authors,
        Genres = genres
    ),
    Book(
        AvailableCopies = 9,
        CreatedAt = "2025-02-22T04:35:01.652579+06:00",
        ID = 6,
        ISBN = "ISBN0000000006",
        PublishedYear = 1937,
        Title = "The Hobbit",
        TotalCopies = 9,
        Authors = authors,
        Genres = genres
    ),
    Book(
        AvailableCopies = 11,
        CreatedAt = "2025-02-22T04:35:01.652579+06:00",
        ID = 7,
        ISBN = "ISBN0000000007",
        PublishedYear = 1953,
        Title = "Fahrenheit 451",
        TotalCopies = 11,
        Authors = authors,
        Genres = genres
    ),
    Book(
        AvailableCopies = 6,
        CreatedAt = "2025-02-22T04:35:01.652579+06:00",
        ID = 8,
        ISBN = "ISBN0000000008",
        PublishedYear = 1851,
        Title = "Moby-Dick",
        TotalCopies = 6,
        Authors = authors,
        Genres = genres
    ),
    Book(
        AvailableCopies = 14,
        CreatedAt = "2025-02-22T04:35:01.652579+06:00",
        ID = 9,
        ISBN = "ISBN0000000009",
        PublishedYear = 1869,
        Title = "War and Peace",
        TotalCopies = 14,
        Authors = authors,
        Genres = genres
    ),
    Book(
        AvailableCopies = 20,
        CreatedAt = "2025-02-22T04:35:01.652579+06:00",
        ID = 10,
        ISBN = "ISBN0000000010",
        PublishedYear = 1954,
        Title = "The Lord of the Rings",
        TotalCopies = 20,
        Authors = authors,
        Genres = genres
    )
)


fun extractDateTime(input: String): String {
    val dateTime = OffsetDateTime.parse(input)
    val outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a")
    return dateTime.format(outputFormat)
}

