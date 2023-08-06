package me.darthwithap.android.simpletweets.core

sealed class UiEvent {
  data class ShowSnackBar(val msg: UiText): UiEvent()
}
