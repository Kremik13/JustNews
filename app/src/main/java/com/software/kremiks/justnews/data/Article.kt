package com.software.kremiks.justnews.data

import com.google.gson.annotations.SerializedName

data class Article(
        @SerializedName("source") val source: Source,
        @SerializedName("title") val title: String,
        @SerializedName("description") val description: String,
        @SerializedName("url") val url: String,
        @SerializedName("urlToImage") val imageUrl: String?
)

data class ArticlesResponse(
        @SerializedName("articles") val articles: List<Article>
)