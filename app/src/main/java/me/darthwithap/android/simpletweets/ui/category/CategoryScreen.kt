package me.darthwithap.android.simpletweets.ui.category

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import me.darthwithap.android.simpletweets.core.UiEvent
import me.darthwithap.android.simpletweets.ui.components.CircularProgressBar

@Composable
fun CategoryScreen(
  scaffoldState: ScaffoldState
) {
  val viewModel: CategoryViewModel = hiltViewModel()
  val context = LocalContext.current
  val categories = viewModel.categories.collectAsState()

  LaunchedEffect(key1 = true) {
    viewModel.uiEvent.collect {
      when (it) {
        is UiEvent.ShowSnackBar -> {
          scaffoldState.snackbarHostState.showSnackbar(it.msg.asString(context))
        }
      }
    }
  }

  CircularProgressBar(categories.value.isEmpty())
  LazyVerticalGrid(columns = GridCells.Fixed(2)) {
    items(categories.value) {
      CategoryItem(category = it)
    }
  }
}