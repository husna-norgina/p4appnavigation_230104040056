package id.antasari.p4appnavigation_230104040056.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import id.antasari.p4appnavigation_230104040056.viewmodel.FormViewModel

/* --- Activity C: Form Input --- */
@Composable
fun ActivityCScreen(onSend: (String, String) -> Unit) {
    val formVm: FormViewModel = viewModel()

    // --- State lokal dengan rememberSaveable untuk tahan rotasi / kill ringan
    var name by rememberSaveable { mutableStateOf("") }
    var nim by rememberSaveable { mutableStateOf("") }

    // --- Prefill dari ViewModel
    val savedName by formVm.name.collectAsState()
    val savedNim by formVm.nim.collectAsState()
    LaunchedEffect(savedName, savedNim) {
        if (name.isEmpty() && savedName.isNotEmpty()) name = savedName
        if (nim.isEmpty() && savedNim.isNotEmpty()) nim = savedNim
    }

    var showSnackbar by remember { mutableStateOf(false) }
    var snackbarMessage by remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }

    // --- Auto-save saat keluar Composable
    DisposableEffect(name, nim) {
        onDispose {
            if (name.isNotBlank() || nim.isNotBlank()) {
                formVm.save(name.trim(), nim.trim())
            }
        }
    }

    LaunchedEffect(showSnackbar) {
        if (showSnackbar) {
            snackbarHostState.showSnackbar(snackbarMessage)
            showSnackbar = false
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card {
                Column(
                    Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("Data Input Form", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Divider(
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                        thickness = .5.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") },
                        leadingIcon = { Icon(Icons.Outlined.Person, contentDescription = null) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = LocalTextStyle.current.copy(fontWeight = FontWeight.Bold)
                    )

                    OutlinedTextField(
                        value = nim,
                        onValueChange = { nim = it },
                        label = { Text("Student ID") },
                        leadingIcon = { Icon(Icons.Outlined.CreditCard, contentDescription = null) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = LocalTextStyle.current.copy(fontWeight = FontWeight.Bold)
                    )


                    // --- Komentar edukatif tentang Intent ---
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        """
                        // Intent (edukasi):
                        // val intent = Intent(this, ActivityD::class.java)
                        // intent.putExtra("NAME", name)
                        // intent.putExtra("STUDENT_ID", nim)
                        // startActivity(intent)
                    
                        // Compose Navigation -> kirim via argumen rute
                        """.trimIndent()
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            when {
                                name.isBlank() || nim.isBlank() -> {
                                    snackbarMessage = "Name & NIM tidak boleh kosong!"
                                    showSnackbar = true
                                }
                                !name.matches(Regex("^[A-Za-z ]+$")) -> {
                                    snackbarMessage = "Nama hanya boleh berisi huruf!"
                                    showSnackbar = true
                                }
                                !nim.matches(Regex("^[0-9]+$")) -> {
                                    snackbarMessage = "NIM hanya boleh berisi angka!"
                                    showSnackbar = true
                                }
                                else -> {
                                    // ✅ Valid → simpan & navigasi
                                    formVm.save(name.trim(), nim.trim())
                                    onSend(name.trim(), nim.trim())
                                }
                            }
                        },
                        enabled = true,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Send to Detail")
                    }
                }
            }

            InfoCard(
                title = "Intent Extras",
                bullets = listOf(
                    "Data dikirim sebagai key-value pairs",
                    "Mendukung primitif, String, Parcelable",
                    "Di Compose Navigation, kita gunakan argumen rute"
                )
            )
        }
    }
}

/* --- Activity D: Tampilkan Data --- */
@Composable
fun ActivityDScreen(name: String, nim: String, onResend: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card {
            Column(
                Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Received Data", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)

                ElevatedCard {
                    ListItem(
                        headlineContent = { Text("Name", fontWeight = FontWeight.Bold) },
                        supportingContent = {
                            Text(name, fontWeight = FontWeight.Bold) },
                        leadingContent = { Icon(Icons.Outlined.Person, null) }
                    )
                }

                ElevatedCard {
                    ListItem(
                        headlineContent = { Text("Student ID", fontWeight = FontWeight.Bold) },
                        supportingContent = { Text(nim, fontWeight = FontWeight.Bold) },
                        leadingContent = { Icon(Icons.Outlined.CreditCard, null) }
                    )
                }

                // --- Komentar ---
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    """
                        // Klasik:
                        // val name = intent.getStringExtra("NAME")
                        // val studentId = intent.getStringExtra("STUDENT_ID")
                        // Compose Navigation: data dibaca dari argumen rute di NavGraph.
                        """.trimIndent()
                )
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedButton(
                    onClick = onResend,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Resend / Edit", fontWeight = FontWeight.Bold)
                }
            }
        }

        InfoCard(
            title = "Data Flow",
            bullets = listOf(
                "Activity C: user input",
                "Argumen rute",
                "Activity D: tampilkan hasil"
            )
        )
    }
}

/* --- Komponen kecil lokal --- */
@Composable
private fun InfoCard(title: String, bullets: List<String>) {
    Card {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium,  fontWeight = FontWeight.Bold)
            bullets.forEach { Text("• $it") }
        }
    }
}

