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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.library.model.BorrowedBook
import com.example.library.nvigation.Routes

@Composable
fun BorrowedBookScreen(navController: NavHostController) {
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
            items(borrowedBook) { i ->
                BorrowedBookCard()
            }
        }

    }
}


@Composable
fun BorrowedBookCard(
    modifier: Modifier = Modifier,
    book: BorrowedBook = borrowedBook[0]
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        Text(
            text = book.BookISBN,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 14.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "TAKEN BY: " + book.StudentID,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "TAKEN AT: " + extractDateTime(book.TakenAt),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "RETURNED AT: " + extractDateTime(book.ReturnAt),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            maxLines = 1
        )

        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "RETURNED: " + book.Returned,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            maxLines = 1
        )
    }
}


val borrowedBook = arrayOf(
    BorrowedBook(
        BookISBN = "978-3-16-148410-0",
        ID = 1,
        ReturnAt = "2023-11-01T10:00:00Z",
        Returned = false,
        StudentID = 101,
        TakenAt = "2023-10-01T09:00:00Z"
    ),
    BorrowedBook(
        BookISBN = "978-1-23-456789-0",
        ID = 2,
        ReturnAt = "2023-11-02T11:00:00Z",
        Returned = true,
        StudentID = 102,
        TakenAt = "2023-10-02T10:00:00Z"
    ),
    BorrowedBook(
        BookISBN = "978-0-12-345678-9",
        ID = 3,
        ReturnAt = "2023-11-03T12:00:00Z",
        Returned = false,
        StudentID = 103,
        TakenAt = "2023-10-03T11:00:00Z"
    ),
    BorrowedBook(
        BookISBN = "978-1-11-111111-1",
        ID = 4,
        ReturnAt = "2023-11-04T13:00:00Z",
        Returned = true,
        StudentID = 104,
        TakenAt = "2023-10-04T12:00:00Z"
    ),
    BorrowedBook(
        BookISBN = "978-2-22-222222-2",
        ID = 5,
        ReturnAt = "2023-11-05T14:00:00Z",
        Returned = false,
        StudentID = 105,
        TakenAt = "2023-10-05T13:00:00Z"
    ),
    BorrowedBook(
        BookISBN = "978-3-33-333333-3",
        ID = 6,
        ReturnAt = "2023-11-06T15:00:00Z",
        Returned = true,
        StudentID = 106,
        TakenAt = "2023-10-06T14:00:00Z"
    ),
    BorrowedBook(
        BookISBN = "978-4-44-444444-4",
        ID = 7,
        ReturnAt = "2023-11-07T16:00:00Z",
        Returned = false,
        StudentID = 107,
        TakenAt = "2023-10-07T15:00:00Z"
    ),
    BorrowedBook(
        BookISBN = "978-5-55-555555-5",
        ID = 8,
        ReturnAt = "2023-11-08T17:00:00Z",
        Returned = true,
        StudentID = 108,
        TakenAt = "2023-10-08T16:00:00Z"
    ),
    BorrowedBook(
        BookISBN = "978-6-66-666666-6",
        ID = 9,
        ReturnAt = "2023-11-09T18:00:00Z",
        Returned = false,
        StudentID = 109,
        TakenAt = "2023-10-09T17:00:00Z"
    ),
    BorrowedBook(
        BookISBN = "978-7-77-777777-7",
        ID = 10,
        ReturnAt = "2023-11-10T19:00:00Z",
        Returned = true,
        StudentID = 110,
        TakenAt = "2023-10-10T18:00:00Z"
    )
)
