package ru.hmhub.agentsAndroid.utils

import android.util.Log
import androidx.navigation.NavHostController
import ru.hmhub.agentsAndroid.ui.navigation.NavigationRoutes

fun NavHostController.safePopBackStack(): Boolean{
    return if(this.currentBackStackEntry?.destination?.route!! != NavigationRoutes.NewsScreen.route) {
        Log.d("route", this.currentBackStackEntry?.destination?.route!!)
        this.popBackStack()
    } else {
        false
    }
}