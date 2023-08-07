package me.darthwithap.android.simpletweets.domain.repository

import kotlinx.coroutines.flow.Flow
import me.darthwithap.android.simpletweets.domain.model.Tweet
import me.darthwithap.android.simpletweets.domain.util.Result

interface TweetsRepository {
  suspend fun getCategories(): Flow<Result<List<String>>>
  suspend fun getTweets(category: String): Flow<Result<List<Tweet>>>
}