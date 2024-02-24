package ru.hmhub.agentsAndroid.ui.composables.shared_ui_elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.hmhub.agentsAndroid.ui.navigation.NavigationRoutes

@Composable
fun DefaultBottomBar(
    navigator: NavHostController,
    currentPage: NavigationRoutes
){
    BottomAppBar(
        containerColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                imageVector = Icons.Default.Newspaper,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        if (currentPage != NavigationRoutes.NewsScreen) {
                            navigator.navigate(NavigationRoutes.NewsScreen.route)
                        }
                    }
                    .size(44.dp),
                tint = if(currentPage == NavigationRoutes.NewsScreen) MaterialTheme.colorScheme.primary else Color.Black
            )
            Icon(
                imageVector = Icons.Default.EmojiEvents,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        if (currentPage != NavigationRoutes.AchievementsScreen) {
                            navigator.navigate(NavigationRoutes.AchievementsScreen.route)
                        }
                    }
                    .size(44.dp),
                tint = if(currentPage == NavigationRoutes.AchievementsScreen) MaterialTheme.colorScheme.primary else Color.Black
            )
            Icon(
                imageVector = Icons.Default.Leaderboard,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        if (currentPage != NavigationRoutes.RatingScreen) {
                            navigator.navigate(NavigationRoutes.RatingScreen.route)
                        }
                    }
                    .size(44.dp),
                tint = if(currentPage == NavigationRoutes.RatingScreen) MaterialTheme.colorScheme.primary else Color.Black
            )
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        if (currentPage != NavigationRoutes.ProfileScreen) {
                            navigator.navigate(NavigationRoutes.ProfileScreen.withArgs(0))
                        }
                    }
                    .size(44.dp),
                tint = if(currentPage == NavigationRoutes.ProfileScreen) MaterialTheme.colorScheme.primary else Color.Black
            )
        }
    }
}