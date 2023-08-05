package me.darthwithap.android.simpletweets.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.darthwithap.android.simpletweets.data.remote.TweetsApi
import me.darthwithap.android.simpletweets.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  fun provideRetrofit(): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  @Provides
  @Singleton
  fun provideTweetsApi(retrofit: Retrofit): TweetsApi {
    return retrofit.create(TweetsApi::class.java)
  }
}