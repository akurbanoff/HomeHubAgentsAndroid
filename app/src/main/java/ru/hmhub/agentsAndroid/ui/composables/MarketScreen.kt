package ru.hmhub.agentsAndroid.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.hmhub.agentsAndroid.R
import ru.hmhub.agentsAndroid.ui.composables.shared_ui_elements.DefaultBottomBar
import ru.hmhub.agentsAndroid.ui.composables.shared_ui_elements.DefaultTopAppBar
import ru.hmhub.agentsAndroid.ui.navigation.NavigationRoutes

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MarketScreen(id: Int = 0, navigator: NavHostController = rememberNavController()){
    val title = "Магазин"
    Scaffold(
        topBar = { DefaultTopAppBar(title = title, navigator = navigator, isAccountShowable = true) },
        bottomBar = { DefaultBottomBar(navigator = navigator, currentPage = NavigationRoutes.MarketScreen) },
        modifier = Modifier.padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            item {
                SingleMarketElement(title = "автомобиль", image = R.drawable.ic_market_car, price = 1_000_000, photoAlignment = Alignment.CenterStart)
                DoubleMarketElement(
                    firstTitle = "10 баннеров",
                    firstPrice = 500,
                    secondTitle = "следующий общий клиент",
                    secondPrice = 700
                )
                SingleMarketElement(title = "отпуск на 30 дней", image = R.drawable.ic_market_holiday, price = 5_000, photoAlignment = Alignment.CenterEnd)
                DoubleMarketElement(
                    firstTitle = "10 баннеров",
                    firstPrice = 500,
                    secondTitle = "следующий общий клиент",
                    secondPrice = 700
                )
            }
        }
    }
}

@Composable
private fun SingleMarketElement(title: String, image: Int, price: Int, photoAlignment: Alignment) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(color = Color.LightGray)
    ){
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = photoAlignment,
            alpha = 0.5f,
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center),
                //.padding(start = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .background(color = Color.White, shape = MaterialTheme.shapes.small)
                    .padding(4.dp)
            ) {
                Text(
                    text = price.toString(),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_hubcoin),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(30.dp)
                )
            }
        }
    }
}

@Composable
private fun DoubleMarketElement(firstTitle: String, firstPrice: Int, secondTitle: String, secondPrice: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        SmallElement(title = firstTitle, price = firstPrice)
        SmallElement(title = secondTitle, price = secondPrice)
    }
}

@Composable
private fun SmallElement(title: String, price: Int) {
    Column(
        modifier = Modifier
            .size(height = 150.dp, width = 150.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(color = Color.White, shape = MaterialTheme.shapes.medium)
                    .padding(4.dp)
            ) {
                Text(
                    text = price.toString(),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_hubcoin),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(30.dp)
                )
            }
        }
    }
}

//@Composable
//private fun SmallElement(title: String, price: Int) {
//    Column(
//        modifier = Modifier
//            .size(height = 150.dp, width = 150.dp)
//            .clip(MaterialTheme.shapes.medium)
//            .background(Color.LightGray)
//            .padding(8.dp),
//        verticalArrangement = Arrangement.Bottom, // Размещаем Row внизу
//        horizontalAlignment = Alignment.CenterHorizontally // Выравниваем по центру по горизонтали
//    ) {
//        Box(
//            modifier = Modifier.fillMaxHeight(),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                text = title,
//                textAlign = TextAlign.Center,
//                style = MaterialTheme.typography.titleLarge,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.fillMaxWidth() // Растягиваем текст на всю ширину
//            )
//            Box(
//                contentAlignment = Alignment.BottomCenter,
//                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter) // Растягиваем Box на всю ширину
//            ) {
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .clip(MaterialTheme.shapes.medium)
//                        .background(Color.White)
//                        .padding(8.dp)
//                ) {
//                    Text(
//                        text = price.toString(),
//                        fontWeight = FontWeight.Bold,
//                        style = MaterialTheme.typography.titleMedium
//                    )
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_hubcoin),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(30.dp)
//                    )
//                }
//            }
//        }
//    }
//}