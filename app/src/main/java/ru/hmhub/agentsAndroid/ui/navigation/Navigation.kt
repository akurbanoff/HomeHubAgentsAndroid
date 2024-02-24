package ru.hmhub.agentsAndroid.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.hmhub.agentsAndroid.ui.composables.AchievementsDetailScreen
import ru.hmhub.agentsAndroid.ui.composables.AchievementsScreen
import ru.hmhub.agentsAndroid.ui.composables.AdminScreen
import ru.hmhub.agentsAndroid.ui.composables.LoginScreen
import ru.hmhub.agentsAndroid.ui.composables.MarketScreen
import ru.hmhub.agentsAndroid.ui.composables.NewsDetailScreen
import ru.hmhub.agentsAndroid.ui.composables.NewsScreen
import ru.hmhub.agentsAndroid.ui.composables.ProfileScreen
import ru.hmhub.agentsAndroid.ui.composables.RatingScreen
import ru.hmhub.agentsAndroid.ui.composables.RegistrationScreen
import ru.hmhub.agentsAndroid.ui.composables.TradeDetailScreen
import ru.hmhub.agentsAndroid.ui.composables.TradesScreen
import ru.hmhub.agentsAndroid.ui.viewModels.SampleLocalViewModel

@Composable
fun Navigation(sampleLocalViewModel: SampleLocalViewModel) {
    val navigator = rememberNavController()

    var isNewsDetailOpen by remember{ mutableStateOf(false) }
    var isMainNavRoutesOpen by remember{ mutableStateOf(false) }
    var isTradeDetailOpen by remember { mutableStateOf(false) }
    var isTradeScreenExit by remember{ mutableStateOf(true) }
    var isRegistrationExit by remember{ mutableStateOf(false) }

    NavHost(navController = navigator, startDestination = NavigationRoutes.LoginScreen.route){
        composable(NavigationRoutes.LoginScreen.route){
            LoginScreen(navigator = navigator)
        }
        composable(
            route = NavigationRoutes.RegistrationScreen.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
            },
            exitTransition = {
                if(isRegistrationExit) {
                    slideOutHorizontally(
                        targetOffsetX = { it },
                        animationSpec = tween(durationMillis = 500, delayMillis = 100)
                    )
                } else {
                    ExitTransition.None
                }
            }
            ){
            isRegistrationExit = true
            RegistrationScreen(navigator = navigator)
        }

        composable(
            route = NavigationRoutes.NewsScreen.route,
            enterTransition = {
                isRegistrationExit = false
                if(isNewsDetailOpen) {
                    isNewsDetailOpen = false
                    EnterTransition.None
                } else if(isMainNavRoutesOpen){
                    isMainNavRoutesOpen = false
                    EnterTransition.None
                } else {
                    slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = tween(durationMillis = 500, delayMillis = 100)
                    )
                }
            },
//            exitTransition = {
//                slideOutHorizontally(targetOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
//            }
        ){
            NewsScreen(navigator = navigator)
        }

        composable(
            NavigationRoutes.NewsDetailScreen.route + "/{news_id}", arguments = listOf(
            navArgument("news_id"){type = NavType.IntType}
        ),
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
            }
        ){backStackEntry -> backStackEntry.arguments?.let {
            val newsId = it.getInt("news_id")
            isNewsDetailOpen = true
            NewsDetailScreen(id = newsId, navigator = navigator)
            }
        }

        composable(
            route = NavigationRoutes.RatingScreen.route,
        ){
            isMainNavRoutesOpen = true
            RatingScreen(navigator = navigator)
        }

        composable(
            route = NavigationRoutes.AchievementsScreen.route,
        ){
            isMainNavRoutesOpen = true
            AchievementsScreen(navigator = navigator)
        }

        composable(
            route = NavigationRoutes.AchievementsDetailScreen.route + "/{achieve_id}", arguments = listOf(
            navArgument("achieve_id"){type = NavType.IntType}
        ),
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
            }
        ){it.arguments?.let {
            val achieveId = it.getInt("achieve_id")
            AchievementsDetailScreen(id = achieveId)
        }}

        composable(
            route = NavigationRoutes.ProfileScreen.route + "/{profile_id}", arguments = listOf(
            navArgument("profile_id"){type = NavType.IntType}
        ),
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
//            },
//            exitTransition = {
//                slideOutHorizontally(targetOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
//            }
        ){it.arguments?.let {
            val profileId = it.getInt("profile_id")
            isMainNavRoutesOpen = true
            ProfileScreen(id = profileId, navigator = navigator)
        } }

        composable(
            route = NavigationRoutes.TradesScreen.route + "/{profile_id}", arguments = listOf(
            navArgument("profile_id"){type = NavType.IntType}
        ),
            enterTransition = {
                if(isTradeDetailOpen){
                    isTradeDetailOpen = false
                    EnterTransition.None
                } else {
                    slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = tween(durationMillis = 500, delayMillis = 100)
                    )
                }
            },
//            exitTransition = {
//                if(isTradeScreenExit){
//                    slideOutHorizontally(
//                        targetOffsetX = { it },
//                        animationSpec = tween(durationMillis = 500, delayMillis = 100)
//                    )
//                } else {
//                    isTradeScreenExit = true
//                    ExitTransition.None
//                }
//            }
        ){it.arguments?.let {
          val profileId = it.getInt("profile_id")
          TradesScreen(id = profileId, navigator = navigator)
        } }

        composable(
            route = NavigationRoutes.TradeDetailScreen.route + "/{trade_id}", arguments = listOf(
            navArgument("trade_id"){type = NavType.IntType}
        ),
            enterTransition = {
                isTradeScreenExit = false
                slideInHorizontally(initialOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
            }
        ){it.arguments?.let {
            val tradeId = it.getInt("trade_id")
            isTradeDetailOpen = true
            TradeDetailScreen(id = tradeId, navigator = navigator)
        } }

        composable(
            route = NavigationRoutes.MarketScreen.route + "/{user_id}", arguments = listOf(
            navArgument("user_id"){type = NavType.IntType}
        ),
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
            }
        ){it.arguments?.let {
          val userId = it.getInt("user_id")
          MarketScreen(id = userId, navigator = navigator)
        } }

        composable(
            route = NavigationRoutes.AdminScreen.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = {it}, animationSpec = tween(durationMillis = 500, delayMillis = 100))
            }
        ){
            AdminScreen(navigator = navigator)
        }
    }
}