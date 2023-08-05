package me.darthwithap.android.simpletweets.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import me.darthwithap.android.simpletweets.domain.model.Tweet
import me.darthwithap.android.simpletweets.domain.repository.TweetsRepository
import me.darthwithap.android.simpletweets.domain.util.Result
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(
  private val tweetsRepository: TweetsRepository
) : ViewModel() {
  private val _event: MutableSharedFlow<TweetsEvent> = MutableSharedFlow()
  val event: SharedFlow<TweetsEvent>
    get() = _event

  init {
    fetchTweets("")
  }

  private fun fetchTweets(category: String) {
    viewModelScope.launch {
      _event.emit(TweetsEvent.TweetsLoading)
      tweetsRepository.getTweets(category).collectLatest {
        if (it is Result.Success) {
          _event.emit(TweetsEvent.TweetsSuccess(it.data.tweets))
        } else if (it is Result.Error) {
          _event.emit(TweetsEvent.TweetsError(it.msg))
        }
      }
    }
  }

  sealed class TweetsEvent {
    object TweetsLoading : TweetsEvent()
    data class TweetsSuccess(val tweets: List<Tweet>) : TweetsEvent()
    data class TweetsError(val msg: String) : TweetsEvent()
  }
}