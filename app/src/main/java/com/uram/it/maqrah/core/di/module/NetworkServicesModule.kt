package com.uram.it.maqrah.core.di.module

import com.uram.it.maqrah.features.news.data.data_source.remote.NewsServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
@InstallIn(SingletonComponent::class)
object NetworkServicesModule {

  @Provides
  @Singleton
  fun provideNewsServices(retrofit: Retrofit): NewsServices {
    return retrofit.create(NewsServices::class.java)
  }
}