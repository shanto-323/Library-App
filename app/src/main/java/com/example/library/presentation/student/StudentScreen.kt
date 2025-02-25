package com.example.library.presentation.student

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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.library.domain.model.student.Student
import com.example.library.presentation.books.extractDateTime
import com.example.library.presentation.nvigation.Routes

@Composable
fun StudentScreen(
    navController: NavHostController,
    viewModel: StudentViewModel = hiltViewModel()
) {
    val students = viewModel.state.collectAsState().value

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
            items(students.size) { i ->
                StudentCard(
                    student = students[i]
                )
            }

        }

    }
}

@Composable
fun StudentCard(
    student: Student = students[0]
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        Text(
            text = student.Name,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 16.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "NUMBER: " + student.Phone,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "EMAIL: " + student.Email,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "Active: " + student.IsActive,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            maxLines = 1
        )

        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "DATE ADDED: " + extractDateTime(student.CreatedAt),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 8.sp,
            maxLines = 1
        )
    }
}


val students = arrayOf(
    Student(
        CreatedAt = "2023-10-01T10:00:00Z",
        Email = "student1@example.com",
        ID = 1,
        IsActive = true,
        Name = "John Doe",
        Phone = "123-456-7890"
    ),
    Student(
        CreatedAt = "2023-10-02T11:00:00Z",
        Email = "student2@example.com",
        ID = 2,
        IsActive = true,
        Name = "Jane Smith",
        Phone = "234-567-8901"
    ),
    Student(
        CreatedAt = "2023-10-03T12:00:00Z",
        Email = "student3@example.com",
        ID = 3,
        IsActive = false,
        Name = "Alice Johnson",
        Phone = "345-678-9012"
    ),
    Student(
        CreatedAt = "2023-10-04T13:00:00Z",
        Email = "student4@example.com",
        ID = 4,
        IsActive = true,
        Name = "Bob Brown",
        Phone = "456-789-0123"
    ),
    Student(
        CreatedAt = "2023-10-05T14:00:00Z",
        Email = "student5@example.com",
        ID = 5,
        IsActive = false,
        Name = "Charlie Davis",
        Phone = "567-890-1234"
    ),
    Student(
        CreatedAt = "2023-10-06T15:00:00Z",
        Email = "student6@example.com",
        ID = 6,
        IsActive = true,
        Name = "Eve Wilson",
        Phone = "678-901-2345"
    ),
    Student(
        CreatedAt = "2023-10-07T16:00:00Z",
        Email = "student7@example.com",
        ID = 7,
        IsActive = true,
        Name = "Frank Martinez",
        Phone = "789-012-3456"
    ),
    Student(
        CreatedAt = "2023-10-08T17:00:00Z",
        Email = "student8@example.com",
        ID = 8,
        IsActive = false,
        Name = "Grace Lee",
        Phone = "890-123-4567"
    ),
    Student(
        CreatedAt = "2023-10-09T18:00:00Z",
        Email = "student9@example.com",
        ID = 9,
        IsActive = true,
        Name = "Henry Garcia",
        Phone = "901-234-5678"
    ),
    Student(
        CreatedAt = "2023-10-10T19:00:00Z",
        Email = "student10@example.com",
        ID = 10,
        IsActive = true,
        Name = "Ivy Hernandez",
        Phone = "012-345-6789"
    )
)