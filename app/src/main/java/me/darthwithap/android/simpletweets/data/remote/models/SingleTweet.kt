package me.darthwithap.android.simpletweets.data.remote.models

import me.darthwithap.android.simpletweets.domain.model.Tweet

data class SingleTweet(
  val category: String,
  val text: String
) {
  fun toTweet(): Tweet {
    return Tweet(category, text)
  }
}