package ru.hmhub.agentsAndroid.ui.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.hmhub.agentsAndroid.ui.composables.shared_ui_elements.DefaultBottomBar
import ru.hmhub.agentsAndroid.ui.composables.shared_ui_elements.DefaultTopAppBar
import ru.hmhub.agentsAndroid.ui.navigation.NavigationRoutes
import ru.hmhub.agentsAndroid.R

private val list1 = listOf(
    "Андрей Васильевич Ребров" to R.drawable.ic_photo,
    "Андрей Васильевич Ребров" to R.drawable.ic_photo,
    "Андрей Васильевич Ребров" to R.drawable.ic_photo,
    "Андрей Васильевич Ребров" to R.drawable.ic_photo,
    "Андрей Васильевич Ребров" to R.drawable.ic_photo,
)

@Preview(showBackground = true)
@Composable
fun RatingScreen(navigator: NavHostController = rememberNavController()){
    val title = "Рейтинг"

    var openMenu by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { DefaultTopAppBar(title = title, navigator = navigator) },
        bottomBar = { DefaultBottomBar(navigator = navigator, currentPage = NavigationRoutes.RatingScreen) },
        modifier = Modifier.padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier.background(
                            color = Color.LightGray,
                            shape = MaterialTheme.shapes.large
                        )
                    ) {
                        Text(
                            text = "ТОП 10",
                            modifier = Modifier
                                .padding(8.dp)
                                .align(Alignment.Center),
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }
                }
            }
            item {
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        OutlinedButton(
                            onClick = { openMenu = !openMenu },
                            shape = MaterialTheme.shapes.medium,
                            contentPadding = PaddingValues(4.dp),
                            modifier = Modifier.align(Alignment.CenterEnd)
                        ) {
                            Icon(
                                imageVector = Icons.Default.FilterList,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp),
                                tint = Color.Black
                            )
                        }
                        DropdownMenu(
                            expanded = openMenu,
                            onDismissRequest = { openMenu = false },
                            modifier = Modifier.clip(MaterialTheme.shapes.medium)
                        ) {
                            DropdownMenuItem(
                                text = {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(text = "по доходу")
                                        Icon(
                                            imageVector = Icons.Default.AttachMoney,
                                            contentDescription = null
                                        )
                                    }
                                },
                                onClick = { /*TODO*/ }
                            )
                            DropdownMenuItem(
                                text = {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(text = "по рангу")
                                        Icon(
                                            imageVector = Icons.Default.MilitaryTech,
                                            contentDescription = null
                                        )
                                    }
                                },
                                onClick = { /*TODO*/ }
                            )
                            DropdownMenuItem(
                                text = {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(text = "по количеству HC")
                                        Image(
                                            painter = painterResource(id = R.drawable.ic_hubcoin),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .size(20.dp)
                                        )
                                    }
                                },
                                onClick = { /*TODO*/ }
                            )
                        }
                    }
                }
            }
            items(list1){
                RatingPerson(name = it.first, photo = it.second, navigator = navigator)
            }
        }
    }
}

@SuppressLint("Range")
@Composable
fun RatingPerson(name: String, photo: Int, navigator: NavHostController) {
    val rank = "продвинутый"
    val achieve = "10,5 млн руб. за год"
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navigator.navigate(NavigationRoutes.ProfileScreen.withArgs(0)) },
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            ),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(photo),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .size(height = 70.dp, width = 70.dp),
                    contentScale = ContentScale.FillBounds,
                )
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = name,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = rank,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = achieve,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
//        Button(
//            onClick = { navigator.navigate(NavigationRoutes.NewsScreen.route) },
//            modifier = Modifier
//                .align(Alignment.CenterEnd)
//                .size(50.dp),
//            shape = CircleShape,
//            contentPadding = PaddingValues(8.dp)
//        ) {
//            Icon(
//                imageVector = Icons.AutoMirrored.Filled.ArrowRightAlt,
//                contentDescription = null,
//                modifier = Modifier.size(35.dp)
//            )
//        }
    }
}