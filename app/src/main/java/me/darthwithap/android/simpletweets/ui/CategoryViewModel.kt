package me.darthwithap.android.simpletweets.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import me.darthwithap.android.simpletweets.domain.repository.TweetsRepository
import me.darthwithap.android.simpletweets.domain.util.Result
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
  private val tweetsRepository: TweetsRepository
) : ViewModel() {
  private val _event: MutableSharedFlow<CategoryEvent> = MutableSharedFlow()
  val event: SharedFlow<CategoryEvent>
    get() = _event

  init {
    fetchCategories()
  }

  private fun fetchCategories() {
    viewModelScope.launch {
      _event.emit(CategoryEvent.CategoriesLoading)
      tweetsRepository.getCategories().collectLatest {
        if (it is Result.Success) {
          _event.emit(CategoryEvent.CategoriesSuccess(it.data))
        } else if (it is Result.Error) {
          _event.emit(CategoryEvent.CategoriesError(it.msg))
        }
      }
    }
  }

  sealed class CategoryEvent {
    data class CategoriesSuccess(val categories: List<String>) : CategoryEvent()
    object CategoriesLoading : CategoryEvent()
    data class CategoriesError(val msg: String) : CategoryEvent()
  }
}