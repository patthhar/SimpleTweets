package me.darthwithap.android.simpletweets.data.remote

import me.darthwithap.android.simpletweets.data.remote.models.TweetsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface TweetsApi {

  @GET("/b/64ce45de9d312622a38c55d5")
  suspend fun getTweets(
    @Header("X-JSON-Path") categoryHeader: String,
    @Query("meta") meta: Boolean = false
  ): Response<TweetsResponse>

  @GET("/b/64ce45de9d312622a38c55d5")
  @Headers("X-JSON-Path  : tweets..category")
  suspend fun getCategories(
    @Query("meta") meta: Boolean = false
  ): Response<List<String>>

}