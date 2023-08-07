package me.darthwithap.android.simpletweets.ui.tweets

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import me.darthwithap.android.simpletweets.core.UiEvent

@Composable
fun TweetsScreen(
  scaffoldState: ScaffoldState
) {
  val viewModel: TweetsViewModel = hiltViewModel()
  val context = LocalContext.current

  val tweets = viewModel.tweets.collectAsState()

  LaunchedEffect(key1 = true) {
    viewModel.uiEvent.collect { event ->
      when (event) {
        is UiEvent.ShowSnackBar ->
          scaffoldState.snackbarHostState.showSnackbar(
            event.msg.asString(
              context
            )
          )
      }
    }
  }

  LazyColumn() {
    items(tweets.value) {
      TweetItem(text = it.text)
    }
  }
}