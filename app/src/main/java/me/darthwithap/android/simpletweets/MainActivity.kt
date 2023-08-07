package me.darthwithap.android.simpletweets

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import me.darthwithap.android.simpletweets.ui.TweetsApp
import me.darthwithap.android.simpletweets.ui.theme.SimpleTweetsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @RequiresApi(Build.VERSION_CODES.O)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SimpleTweetsTheme {
        val scaffoldState = rememberScaffoldState()
        Scaffold(
          modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState
        ) {
          Box(modifier = Modifier.padding(it)) {
            TweetsApp(scaffoldState)
          }
        }
      }
    }
  }
}