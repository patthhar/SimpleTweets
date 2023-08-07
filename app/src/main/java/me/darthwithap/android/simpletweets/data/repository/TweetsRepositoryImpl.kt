package me.darthwithap.android.simpletweets.data.repository

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.darthwithap.android.simpletweets.R
import me.darthwithap.android.simpletweets.data.remote.TweetsApi
import me.darthwithap.android.simpletweets.domain.model.Tweet
import me.darthwithap.android.simpletweets.domain.repository.TweetsRepository
import me.darthwithap.android.simpletweets.domain.util.Result
import me.darthwithap.android.simpletweets.domain.util.isInternetConnected
import javax.inject.Inject

class TweetsRepositoryImpl @Inject constructor(
  private val tweetsApi: TweetsApi,
  private val context: Context
) : TweetsRepository {

  override suspend fun getCategories(): Flow<Result<List<String>>> {
    return flow {
      //emit(Result.Loading) //TODO: Handle how to emit Loading state
      if (!context.isInternetConnected()) {
        emit(Result.Error(context.getString(R.string.internet_error)))
        return@flow
      }
      val response = tweetsApi.getCategories()
      if (response.isSuccessful && !response.body().isNullOrEmpty()) {
        emit(Result.Success(response.body()!!))
      } else emit(Result.Error(context.getString(R.string.network_error)))
    }
  }

  override suspend fun getTweets(category: String): Flow<Result<List<Tweet>>> {
    return flow {
      if (!context.isInternetConnected()) {
        emit(Result.Error(context.getString(R.string.internet_error)))
        return@flow
      }
      val response = tweetsApi.getTweets("tweets[?(@.category==\"$category\")]")
      if (response.isSuccessful && response.body() != null) {
        emit(Result.Success(response.body()!!.map { it.toTweet() }))
      } else emit(Result.Error(context.getString(R.string.network_error)))
    }
  }

}