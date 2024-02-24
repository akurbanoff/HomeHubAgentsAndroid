package ru.hmhub.agentsAndroid.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

val list11 = listOf(
    "Сделать 100 звонков за день" to R.drawable.br,
    "Сделать расслыку по почте" to R.drawable.silver,
    "Сделать 1000 звонков за неделю" to R.drawable.gold,
)

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun AchievementsScreen(navigator: NavHostController = rememberNavController()){
    val title = "Достижения"
    val progress = 0.45f
    var progressBarColor = Color.Green
    if(progress < 0.5f){
        progressBarColor = Color.Red
    } else if(progress > 0.5f && progress < 0.75f){
        progressBarColor = Color.Yellow
    }
    Scaffold(
        topBar = { DefaultTopAppBar(title = title, navigator = navigator) },
        bottomBar = { DefaultBottomBar(navigator = navigator, currentPage = NavigationRoutes.AchievementsScreen) },
        modifier = Modifier.padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            item {
                Box(
                    modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
                ) {
                    Text(
                        text = "Наш успех - Твой успех!",
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_achieve_car),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(230.dp),
                        contentScale = ContentScale.FillBounds
                    )
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_car_scale),
//                        contentDescription = null,
//                        modifier = Modifier.align(Alignment.BottomCenter),
//                        colorFilter = ColorFilter.tint(Color.Black)
//                    )
                    Text(
                        text = "${(0.45f) * 6000000} из 6 000 000",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 8.dp)
                    )
                    LinearProgressIndicator(
                        progress = 0.45f,
                        modifier = Modifier.align(Alignment.BottomCenter),
                        color = progressBarColor
                    )
                }
            }
            stickyHeader {
                Text(
                    text = "Достижения",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            items(list11){
                Achievement(title = it.first, photo = it.second)
            }
        }
    }
}

@Composable
fun Achievement(title: String, photo: Int) {
    val HCAmount = 1
    val expAmount = 5
    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(id = photo),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .clip(CircleShape)
                        .size(70.dp)
                )
                Column(
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text(
                        text = "$HCAmount HC",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "$expAmount EXP",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}