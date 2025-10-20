package id.antasari.p4appnavigation_230104040056.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.antasari.p4appnavigation_230104040056.nav.Route

@Composable
fun HomeScreen(nav: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Navigasi Studio",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )

        Text(
            "Interactive demos for learning Activity & Fragment navigation",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        MenuCard(
            title = "Start Activity",
            desc = "Launch a new Activity using explicit Intent",
            icon = Icons.Default.DirectionsRun,
        ) { nav.navigate(Route.ActivityA.path) }

        MenuCard(
            title = "Send Data",
            desc = "Pass data between Activities using Intent extras",
            icon = Icons.Default.Send
        ) { nav.navigate(Route.ActivityC.path) }

        MenuCard(
            title = "Back Stack",
            desc = "Understand how Android manages Activity stack",
            icon = Icons.Default.Layers
        ) { nav.navigate(Route.Step1.path) }

        MenuCard(
            title = "Activity + Fragment",
            desc = "Bottom navigation with multiple fragments",
            icon = Icons.Default.AutoAwesome
        ) { nav.navigate(Route.Hub.path) }
    }
}

@Composable
private fun MenuCard(
    title: String,
    desc: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            icon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    }
                }

                Spacer(Modifier.width(12.dp))
                Column {
                    Text(title, fontWeight = FontWeight.Bold)
                    Text(desc, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .7f))
                }
            }

            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick = onClick) {
                    Text(text = "Try Demo")
                }
            }
        }
    }
}
