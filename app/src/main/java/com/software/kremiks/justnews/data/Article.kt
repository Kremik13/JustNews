package com.software.kremiks.justnews.data

data class Article(
        val int: Int,
        val source: Source,
        val title: String,
        val description: String,
        val url: String,
        val imageUrl: String?
)