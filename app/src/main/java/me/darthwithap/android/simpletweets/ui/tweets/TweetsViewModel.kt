package me.darthwithap.android.simpletweets.ui.tweets

import androidx.lifecycle.SavedStateHandle
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
import me.darthwithap.android.simpletweets.domain.model.Tweet
import me.darthwithap.android.simpletweets.domain.repository.TweetsRepository
import me.darthwithap.android.simpletweets.domain.util.Result
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(
  private val repository: TweetsRepository,
  savedStateHandle: SavedStateHandle
) : ViewModel() {

  private val _tweets: MutableStateFlow<List<Tweet>> = MutableStateFlow(emptyList())
  val tweets: StateFlow<List<Tweet>>
    get() = _tweets

  private val _uiEvent: Channel<UiEvent> = Channel()
  val uiEvent: Flow<UiEvent> = _uiEvent.receiveAsFlow()

  private val category = savedStateHandle.get<String>("category") ?: "future of ai"

  init {
    fetchCategories()
  }

  private fun fetchCategories() {
    viewModelScope.launch {
      repository.getTweets(category).collectLatest {
        if (it is Result.Success) {
          _tweets.value = it.data
        } else if (it is Result.Error) {
          _uiEvent.send(UiEvent.ShowSnackBar(UiText.DynamicString(it.msg)))
        }
      }
    }
  }
}