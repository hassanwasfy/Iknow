package com.abaferas.repository.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ArticleEntity(
    @PrimaryKey
    val headlineMain: String,
    val webUrl: String,
    val snippet: String,
    val leadParagraph: String,
    val source: String,
    val multimedia: String,
    val headlineKicker: String,
    val headlinePrint: String,
    val keywords: String,
    val pubDate: String,
    val newsDesk: String,
    val sectionName: String,
    val subsectionName: String,
    val byline: String,
)

