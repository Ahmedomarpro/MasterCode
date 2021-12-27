package com.uram.it.maqrah.core.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.uram.it.maqrah.features.news.data.data_source.local.ArticlesDao
import com.uram.it.maqrah.features.news.domain.Converters
import com.uram.it.maqrah.features.news.domain.entity.model.Article

@Database(entities = [Article::class], version = MyDatabase.DATABASE_VERSION)
@TypeConverters(Converters::class)
abstract class MyDatabase : RoomDatabase() {

  companion object {
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "NewsDatabase"
  }

  abstract fun getArticlesDao(): ArticlesDao
}