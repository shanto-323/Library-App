package com.example.library.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.library.R
import com.example.library.presentation.nvigation.Routes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.Route

@Composable
fun HomeScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    NavDrawer(
        scope = scope,
        drawerState = drawerState,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(16.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start)
                        .clickable(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ),
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.padding(30.dp))

                Box {
                    Image(
                        painter = painterResource(id = R.drawable.books),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                }

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Text(
                        text = "LIBRARY",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 42.sp
                    )
                }

                Spacer(modifier = Modifier.padding(30.dp))

                BoxCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    label = "BORROWED-BOOKS",
                    onClick = {
                        navController.navigate(Routes.BorrowedBookScreen.route)
                    }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BoxCard(
                        Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        label = "BOOKS",
                        onClick = {
                            navController.navigate(Routes.BookScreen.route)
                        }
                    )
                    BoxCard(
                        Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        label = "STUDENTS",
                        onClick = {
                            navController.navigate(Routes.StudentScreen.route)
                        }
                    )
                }
            }

        }
    )

}


@Composable
fun BoxCard(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 22.sp
        )
    }
}

@Composable
fun NavDrawer(
    scope: CoroutineScope,
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight()
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    text = "ADMIN",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 22.sp

                )
            }
            Divider()
            NavigationDrawerItem(
                label = { Text(text = "CREATE") },
                selected = false,
                //icon
                onClick = {
                    scope.launch {
                        drawerState.close()
                    }
                }
            )
        },
        drawerState = drawerState,
        gesturesEnabled = true,
        content = content,
    )
}