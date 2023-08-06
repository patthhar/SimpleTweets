package me.darthwithap.android.simpletweets.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import me.darthwithap.android.simpletweets.core.UiEvent
import me.darthwithap.android.simpletweets.core.UiText
import me.darthwithap.android.simpletweets.domain.repository.TweetsRepository
import me.darthwithap.android.simpletweets.domain.util.Result
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
  private val repository: TweetsRepository
) : ViewModel() {

  private val _categories: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
  val categories: StateFlow<List<String>>
    get() = _categories

  private val _uiEvent: Channel<UiEvent> = Channel()
  val uiEvent: Flow<UiEvent> = _uiEvent.receiveAsFlow()

  init {
    fetchCategories()
  }

  private fun fetchCategories() {
    viewModelScope.launch {
      repository.getCategories().collectLatest {
        if (it is Result.Success) {
          _categories.value = it.data.distinct()
        } else if (it is Result.Error) {
          _uiEvent.send(UiEvent.ShowSnackBar(UiText.DynamicString(it.msg)))
        }
      }
    }
  }
}