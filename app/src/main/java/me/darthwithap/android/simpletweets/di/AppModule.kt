package me.darthwithap.android.simpletweets.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.darthwithap.android.simpletweets.data.remote.TweetsApi
import me.darthwithap.android.simpletweets.data.repository.TweetsRepositoryImpl
import me.darthwithap.android.simpletweets.domain.repository.TweetsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  @Provides
  @Singleton
  fun provideAppContext(app: Application): Context {
    return app.applicationContext
  }

  @Provides
  @Singleton
  fun provideTweetsRepository(tweetsApi: TweetsApi, context: Context) : TweetsRepository {
   return TweetsRepositoryImpl(tweetsApi, context)
  }
}