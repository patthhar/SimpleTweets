package me.darthwithap.android.simpletweets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.darthwithap.android.simpletweets.ui.category.CategoryScreen
import me.darthwithap.android.simpletweets.ui.theme.SimpleTweetsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SimpleTweetsTheme {
        val scaffoldState = rememberScaffoldState()
        val navController = rememberNavController()
        Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) { padding ->
          NavHost(
            modifier = Modifier.padding(padding),
            navController = navController,
            startDestination = "category"
          ) {
            composable("category") {
              CategoryScreen(scaffoldState = scaffoldState)
            }
          }
        }
      }
    }
  }
}