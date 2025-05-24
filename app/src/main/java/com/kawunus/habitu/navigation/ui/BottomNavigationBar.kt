package com.kawunus.habitu.navigation.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kawunus.habitu.navigation.model.BottomNavItem

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    NavigationBar {
        BottomNavItem.items.forEach { item ->
            NavigationBarItem(selected = (currentRoute == item.route), onClick = {
                if (currentRoute != item.route) {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }, icon = {
                Icon(
                    painter = painterResource(id = item.iconResId),
                    contentDescription = stringResource(id = item.titleResId)
                )
            })
        }
    }
}