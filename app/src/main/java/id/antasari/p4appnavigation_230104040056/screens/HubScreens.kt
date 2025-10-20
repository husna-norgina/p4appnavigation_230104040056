package id.antasari.p4appnavigation_230104040056.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import id.antasari.p4appnavigation_230104040056.nav.Route

/* ---------------- Hub Tabs ---------------- */
sealed class HubTab(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    data object Dashboard : HubTab("Dashboard", Icons.Outlined.Dashboard)
    data object Messages  : HubTab("Messages", Icons.Outlined.Chat)
    data object Profile   : HubTab("Profile", Icons.Outlined.AccountCircle)
}

/* ---------------- HubScreen ---------------- */
@Composable
fun HubScreen(nav: NavHostController, tab: HubTab) {
    val selectedTab = tab
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab is HubTab.Dashboard,
                    onClick = {
                        nav.navigate(Route.HubDashboard.path) {
                            popUpTo(Route.Hub.path) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = { Icon(HubTab.Dashboard.icon, contentDescription = null) },
                    label = { Text(HubTab.Dashboard.label) }
                )

                NavigationBarItem(
                    selected = selectedTab is HubTab.Messages,
                    onClick = {
                        nav.navigate(Route.HubMessages.path) {
                            popUpTo(Route.Hub.path) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = { Icon(HubTab.Messages.icon, contentDescription = null) },
                    label = { Text(HubTab.Messages.label) }
                )

                NavigationBarItem(
                    selected = selectedTab is HubTab.Profile,
                    onClick = {
                        nav.navigate(Route.HubProfile.path) {
                            popUpTo(Route.Hub.path) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = { Icon(HubTab.Profile.icon, contentDescription = null) },
                    label = { Text(HubTab.Profile.label) }
                )
            }
        }
    ) { padding ->
        when (tab) {
            is HubTab.Dashboard -> DashboardTab(Modifier.padding(padding))
            is HubTab.Messages -> MessagesTab(Modifier.padding(padding)) { mid ->
                nav.navigate(Route.HubMsgDetail.of(mid))
            }
            is HubTab.Profile -> ProfileTab(Modifier.padding(padding))
        }
    }
}

/* ---------------- Tabs ---------------- */
@Composable
private fun DashboardTab(mod: Modifier = Modifier) {
    Column(mod.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Dashboard Fragment", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Card{
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Welcome!", fontWeight = FontWeight.Bold)
                Text("This screen represents a dashboard within one Activity, aggregating key metrics, navigation shortcuts, and recent updates, enabling quick access to core features without switching contexts or launching additional activities.",
                    fontWeight = FontWeight.Bold)
                Text("Layar ini merepresentasikan dasbor dalam satu Activity, yang menggabungkan metrik utama, pintasan navigasi, dan pembaruan terbaru, sehingga memungkinkan akses cepat ke fitur inti tanpa beralih konteks atau meluncurkan Activity lain.",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic)
            }
        }
        // InfoCard("Hints", listOf(
            // "Each tab maps to a fragment-like screen",
            // "Bottom navigation switches tabs within the same Activity",
            // "Back preserves tab state unless the stack is cleared"
        // ))
    }
}

@Composable
private fun MessagesTab(mod: Modifier = Modifier, onOpenDetail: (String) -> Unit) {
    val pastelGreen = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
    val iconTint = MaterialTheme.colorScheme.secondary

    Column(mod.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Messages fragment", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)

        // Item 1
        Card(
            modifier = Modifier.fillMaxWidth().clickable { onOpenDetail("1") }
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    shape = CircleShape,
                    color = pastelGreen
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(Icons.Outlined.Chat, contentDescription = null, tint = iconTint)
                    }
                }

                Spacer(Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text("Android System", fontWeight = FontWeight.Bold)
                    Text("Welcome to Navigation Lab!\nTap to open message details.", fontWeight = FontWeight.SemiBold) }
                    Text("2m", fontWeight = FontWeight.SemiBold)
            }
        }

        // Item 2
        Card(
            modifier = Modifier.fillMaxWidth().clickable { onOpenDetail("2") }
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    shape = CircleShape,
                    color = pastelGreen
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(Icons.Outlined.Chat, contentDescription = null, tint = iconTint)
                    }
                }

                Spacer(Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text("Compose Tips", fontWeight = FontWeight.Bold)
                    Text("Use Scaffold + TopAppBar + NavigationBar", fontWeight = FontWeight.SemiBold) }
                    Text("1h", fontWeight = FontWeight.SemiBold)
            }
        }

        // Item 3
        Card(
            modifier = Modifier.fillMaxWidth().clickable { onOpenDetail("3") }
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    shape = CircleShape,
                    color = pastelGreen
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(Icons.Outlined.Chat, contentDescription = null, tint = iconTint)
                    }
                }

                Spacer(Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text("Release Notes", fontWeight = FontWeight.Bold)
                    Text("Material 3 components power modern UI on Android.", fontWeight = FontWeight.SemiBold) }
                    Text("ytd", fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

/* ---------------- Detail Message ---------------- */
@Composable
fun MessageDetailScreen(id: String, onBack: () -> Unit, mod: Modifier = Modifier) {
    val content = when (id) {
        "1" -> "System: Device setup completed successfully."
        "2" -> "Tips: Use Scaffold + TopAppBar + NavigationBar for clean layouts."
        "3" -> "Release Notes: Material 3 components now improved."
        else -> "Unknown message #$id"
    }

    Column(
        mod.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {

                ElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(0.dp), // sudut lurus
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    ListItem(
                        leadingContent = {
                            Surface(
                                modifier = Modifier.size(40.dp),
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        Icons.Outlined.Chat,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.secondary
                                    )
                                }
                            }
                        },
                        headlineContent = { Text("Message #$id", fontWeight = FontWeight.Bold) },
                        supportingContent = { Text(content, fontWeight = FontWeight.SemiBold) }
                    )
                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    OutlinedButton(onClick = onBack) {
                        Text("Back", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

/* ---------------- Profile Tab ---------------- */
@Composable
private fun ProfileTab(mod: Modifier) {
    Column(mod.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Profile Fragment", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)

        Card {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                ElevatedCard {
                    ListItem(
                        leadingContent = { Icon(Icons.Outlined.AccountCircle, null) },
                        headlineContent = { Text("Husna Norgina", fontWeight = FontWeight.Bold) },
                        supportingContent = { Text("Mobile Programming Student", fontWeight = FontWeight.SemiBold) }
                    )
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                    AssistChip(onClick = {}, label = { Text("Demos Completed", fontWeight = FontWeight.Bold)})
                    AssistChip(onClick = {}, label = { Text("4/4", fontWeight = FontWeight.Bold) })
                }
                /* Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                    AssistChip(onClick = {}, label = { Text("Current Level") })
                    AssistChip(onClick = {}, label = { Text("Intermediate") })
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                    AssistChip(onClick = {}, label = { Text("Navigation Score") })
                    AssistChip(onClick = {}, label = { Text("100%") })
                } */
            }
        }

        /* AssistChip(
            onClick = {},
            label = { Text("Each tab is a fragment-like screen. The Activity controls back stack & transactions.") }
        ) */
    }
}

/* ---------------- Utility ---------------- */
@Composable
private fun InfoCard(title: String, bullets: List<String>) {
    Card {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            bullets.forEach { Text("• $it") }
        }
    }
}
