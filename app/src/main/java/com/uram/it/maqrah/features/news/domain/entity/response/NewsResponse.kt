package com.uram.it.maqrah.features.news.domain.entity.response

import com.uram.it.maqrah.features.news.domain.entity.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)