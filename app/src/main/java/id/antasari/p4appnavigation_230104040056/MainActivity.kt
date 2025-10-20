package id.antasari.p4appnavigation_230104040056

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import id.antasari.p4appnavigation_230104040056.nav.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Theme bawaan template (mis: P4appnavigation_230104040056Theme)
            id.antasari.p4appnavigation_230104040056.ui.theme.P4appnavigation_230104040056Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavGraph()
                }
            }
        }
    }
}
