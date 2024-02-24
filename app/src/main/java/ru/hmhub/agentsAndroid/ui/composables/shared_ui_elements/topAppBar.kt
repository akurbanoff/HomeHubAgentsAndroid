package ru.hmhub.agentsAndroid.ui.composables.shared_ui_elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.West
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.hmhub.agentsAndroid.ui.navigation.NavigationRoutes
import ru.hmhub.agentsAndroid.utils.safePopBackStack
import ru.hmhub.agentsAndroid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopAppBar(
    title: String,
    isUserAdmin: Boolean = false,
    isMainPage: Boolean = false,
    isAccountShowable: Boolean = false,
    //user: User
    navigator: NavHostController
){
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    //modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.displaySmall
                )
                },
        navigationIcon = {
            if(isMainPage){
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.size(44.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Default.West,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            navigator.safePopBackStack()
                        }
                        .size(44.dp)
                )
            }
                         },
        actions = {
            if(isAccountShowable && !isUserAdmin){
                Row(
                    modifier = Modifier
                        .clickable {
                            navigator.navigate(
                                NavigationRoutes.MarketScreen.withArgs(0)
                            )
                        },
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "100",
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_hubcoin),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(30.dp)
                    )
                }
            } else if(isUserAdmin && !isAccountShowable){
                Icon(
                    imageVector = Icons.Default.AdminPanelSettings,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { navigator.navigate(NavigationRoutes.AdminScreen.route) }
                        .size(44.dp)
                )
            }
        }
    )
}