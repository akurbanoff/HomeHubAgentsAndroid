package ru.hmhub.agentsAndroid.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.hmhub.agentsAndroid.R
import ru.hmhub.agentsAndroid.ui.composables.shared_ui_elements.DefaultBottomBar
import ru.hmhub.agentsAndroid.ui.composables.shared_ui_elements.DefaultTopAppBar
import ru.hmhub.agentsAndroid.ui.navigation.NavigationRoutes

val list12 = listOf(
    "Студия 27 кв.м., р-н Энка" to listOf(R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj),
    "Студия 27 кв.м., р-н Энка" to listOf(R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj),
    "Студия 27 кв.м., р-н Энка" to listOf(R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj),
    "Студия 27 кв.м., р-н Энка" to listOf(R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj, R.drawable.ic_test_realstate_obj),
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TradesScreen(id: Int = 0, navigator: NavHostController = rememberNavController()){
    val title = "Архив Сделок"
    Scaffold(
        topBar = { DefaultTopAppBar(title = title, navigator = navigator) },
        bottomBar = { DefaultBottomBar(navigator = navigator, currentPage = NavigationRoutes.TradesScreen) },
        modifier = Modifier.padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            items(list12){
                RealStateObj(title = it.first, photos = it.second, navigator = navigator)
            }
        }
    }
}

@Composable
fun RealStateObj(title: String, photos: List<Int>, navigator: NavHostController) {
    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable { navigator.navigate(NavigationRoutes.TradeDetailScreen.withArgs(0)) }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(photos) {
                    Image(
                        painter = painterResource(it),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clip(MaterialTheme.shapes.small)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "14 Февраля 2024 г.",
                    modifier = Modifier.align(Alignment.Bottom)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.AttachMoney, contentDescription = null)
                    Text(
                        text = "3,2 млн руб.",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}