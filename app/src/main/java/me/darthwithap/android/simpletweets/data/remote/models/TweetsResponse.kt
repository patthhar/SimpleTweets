package me.darthwithap.android.simpletweets.data.remote.models

import me.darthwithap.android.simpletweets.domain.model.Tweets

data class TweetsResponse(
  val singleTweets: List<SingleTweet>
) {
  fun toTweets(): Tweets {
    return Tweets(singleTweets.map { it.toTweet() })
  }
}