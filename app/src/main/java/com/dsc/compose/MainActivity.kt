package com.dsc.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dsc.compose.features.account.Account
import com.dsc.compose.features.home.Home
import com.dsc.compose.features.notifications.Notifications
import com.dsc.compose.features.search.Search
import com.dsc.compose.ui.theme.ComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Surface(color = MaterialTheme.colors.surface) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {
    /*The nav controller is the central part of the navigation component it keeps track of the back
     *stack of the your composable functions that make up your screens
    * */
    val navController = rememberNavController()

    /* creating the navigation host that contains our navigation graph. The navigation graph structure
      *is added through the composable method
      */
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { MyBottomNavigation(navController = navController) }) {
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(it)
        ) {
            composable(route = "home") { Home(navController = navController) }
            composable(route = "search") { Search(navController = navController) }
            composable(route = "notifications") { Notifications(navController = navController) }
            composable(route = "account") { Account(navController = navController) }
        }
    }
}

//bottom Navigation item
sealed class Screen(val route: String, val name: String, val icon: Int) {
    object Home : Screen("home", "Home", R.drawable.ic_baseline_home_24)
    object Search : Screen("search", "Search", R.drawable.ic_baseline_search_24)
    object Notification :
        Screen("notifications", "Notifications", R.drawable.ic_baseline_notifications_none_24)

    object Account : Screen("account", "Account", R.drawable.ic_baseline_account_circle_24)
}

val navItems = listOf<Screen>(
    Screen.Home,
    Screen.Search,
    Screen.Notification,
    Screen.Account
)

@Composable
fun MyBottomNavigation(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    BottomNavigation {
        navItems.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(painter = painterResource(id = it.icon), contentDescription = it.name)
                },
                selected = currentDestination?.hierarchy?.any { nav -> it.route == nav.route } == true,
                onClick = { navController.navigate(it.route) },
                label = { Text(text = it.name) },
                alwaysShowLabel = false
            )

        }
    }
}