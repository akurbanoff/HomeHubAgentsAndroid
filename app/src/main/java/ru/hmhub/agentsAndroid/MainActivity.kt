package ru.hmhub.agentsAndroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.hmhub.agentsAndroid.ui.navigation.Navigation
import ru.hmhub.agentsAndroid.ui.theme.HomeHubTheme
import ru.hmhub.agentsAndroid.ui.viewModels.SampleLocalViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeHubTheme {
                val sampleLocalViewModel = hiltViewModel<SampleLocalViewModel>()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(sampleLocalViewModel = sampleLocalViewModel)
                }
            }
        }
    }
}

