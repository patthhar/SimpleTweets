package me.darthwithap.android.simpletweets.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import me.darthwithap.android.simpletweets.R
import me.darthwithap.android.simpletweets.ui.category.CategoryScreen
import me.darthwithap.android.simpletweets.ui.category.TopBar
import me.darthwithap.android.simpletweets.ui.tweets.TweetsScreen
import me.darthwithap.android.simpletweets.util.navigation.Route

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TweetsApp(
  scaffoldState: ScaffoldState
) {
  val navController = rememberNavController()
  Column(
    modifier = Modifier
      .fillMaxSize(1f)
      .background(Color(R.color.appWhite))
  ) {
    TopBar()
    Spacer(modifier = Modifier.padding(12.dp, 0.dp))
    NavHost(
      navController = navController,
      startDestination = Route.CategoryScreen
    ) {
      composable(Route.CategoryScreen) {
        CategoryScreen(scaffoldState = scaffoldState) {
          navController.navigate(Route.TweetsScreen + "/$it")
        }
      }
      composable(
        route = Route.TweetsScreen + "/{category}",
        arguments = listOf(navArgument("category") {
          type = NavType.StringType
        })
      ) {
        TweetsScreen(scaffoldState = scaffoldState)
      }
    }
  }
}