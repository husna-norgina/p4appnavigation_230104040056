package id.antasari.p4appnavigation_230104040056.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import androidx.compose.ui.text.font.FontWeight
import id.antasari.p4appnavigation_230104040056.screens.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import id.antasari.p4appnavigation_230104040056.R
import androidx.compose.foundation.layout.*
import java.net.URLDecoder

@OptIn(ExperimentalMaterial3Api::class) // ✅ Ini kunci untuk hilangkan warning Material3 experimental API
@Composable
fun NavGraph() {
    val nav = rememberNavController()

    Scaffold(
        topBar = {
            HomeTopBar(nav)
        }
    ) { padding ->
        NavHost(
            modifier = Modifier.padding(padding),
            navController = nav,
            startDestination = Route.Home.path
        ) {
            // 🏠 HOME
            composable(Route.Home.path) { HomeScreen(nav) }

            // ▶️ Activity A -> B
            composable(Route.ActivityA.path) { ActivityAScreen(onOpen = { nav.navigate(Route.ActivityB.path) }) }
            composable(Route.ActivityB.path) { ActivityBScreen() }

            // 📤 Activity C (form) -> Activity D (terima data)
            composable(Route.ActivityC.path) {
                ActivityCScreen(onSend = { name, nim ->
                    nav.navigate(
                        Route.ActivityD.make(
                            name,
                            nim
                        )
                    )
                })
            }

            composable(
                route = Route.ActivityD.path,
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                    navArgument("studentId") { type = NavType.StringType }
                )
            ) { backStack ->
                val name = URLDecoder.decode(backStack.arguments?.getString("name") ?: "", "utf-8")
                val nim =
                    URLDecoder.decode(backStack.arguments?.getString("studentId") ?: "", "utf-8")
                ActivityDScreen(name = name, nim = nim, onResend = { nav.popBackStack() })
            }

            // 🛅 Back Stack demo
            composable(Route.Step1.path) {
                StepScreen(
                    step = 1,
                    onNext = { nav.navigate(Route.Step2.path) },
                    onClearToHome = {
                        nav.navigate(Route.Home.path) {
                            popUpTo(Route.Home.path) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(Route.Step2.path) {
                StepScreen(
                    step = 2,
                    onNext = { nav.navigate(Route.Step3.path) },
                    onClearToHome = {
                        nav.navigate(Route.Home.path) {
                            popUpTo(Route.Home.path) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(Route.Step3.path) {
                StepScreen(
                    step = 3,
                    onNext = null,
                    onClearToHome = {
                        nav.navigate(Route.Home.path) {
                            popUpTo(Route.Home.path) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            // 🧭 Hub (nested graph)
            navigation(startDestination = Route.HubDashboard.path, route = Route.Hub.path) {
                composable(Route.HubDashboard.path) { HubScreen(nav, HubTab.Dashboard) }
                composable(Route.HubMessages.path) { HubScreen(nav, HubTab.Messages) }
                composable(Route.HubProfile.path) { HubScreen(nav, HubTab.Profile) }

                // 🆕 Detail berparameter (Langkah 9)
                composable(
                    route = Route.HubMsgDetail.path,
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id").orEmpty()
                    MessageDetailScreen(id = id, onBack = { nav.popBackStack() })
                }
            }

            // (Tidak perlu placeholder lain)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(nav: NavHostController) {
    val route by nav.currentBackStackEntryAsState()
    val currentRoute = route?.destination?.route ?: ""

    TopAppBar(
        navigationIcon = {
            if (currentRoute != Route.Home.path) {
                IconButton(onClick = { nav.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    if (currentRoute == Route.Home.path) {
                        val iconSize = 32.dp
                        Icon(
                            painter = painterResource(R.drawable.ic_navio),
                            contentDescription = "Navio Icon",
                            modifier = Modifier.size(iconSize),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = stringResource(R.string.app_name),
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    } else {
                        Text(
                            text = currentTitle(nav),
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }

                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Logo Icon",
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.CenterEnd)
                        .padding(end = 12.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
private fun currentTitle(nav: NavHostController): String {
    val route = nav.currentBackStackEntryAsState().value?.destination?.route ?: ""

    return when {
        route.startsWith("hub/messages/detail") -> "Messages Detail"
        route.startsWith("hub/messages")        -> "Messages Fragment"
        route.startsWith("hub/profile")         -> "Profile Fragment"
        route.startsWith("hub/dashboard")       -> "Dashboard Fragment"
        route.startsWith("hub")                 -> "Activity + Fragment Hub"
        route.startsWith("activity_d")          -> "Activity D - Data Display"
        route == Route.ActivityC.path                   -> "Activity C - Send Data"
        route == Route.ActivityA.path                   -> "Activity A"
        route == Route.ActivityB.path                   -> "Launched by Intent"
        route == Route.Step1.path                       -> "Step 1 of 3"
        route == Route.Step2.path                       -> "Step 2 of 3"
        route == Route.Step3.path                       -> "Step 3 of 3"
        else -> "Navigation Lab"
    }
}
