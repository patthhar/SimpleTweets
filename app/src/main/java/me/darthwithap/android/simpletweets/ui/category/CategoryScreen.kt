package me.darthwithap.android.simpletweets.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.darthwithap.android.simpletweets.R
import me.darthwithap.android.simpletweets.core.UiEvent

@Composable
fun CategoryScreen(
  scaffoldState: ScaffoldState,
  onClick: (category: String) -> Unit
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

  if (categories.value.isEmpty()) {
    Box(
      modifier = Modifier.fillMaxSize().background(Color(R.color.appWhite)),
      contentAlignment = Alignment.Center
    ) { CircularProgressIndicator() }
  } else {
    LazyVerticalGrid(
      modifier = Modifier.padding(16.dp, 0.dp),
      columns = GridCells.Fixed(2)
    ) {
      items(categories.value) {
        CategoryItem(category = it, onClick = onClick)
      }
    }
  }
}