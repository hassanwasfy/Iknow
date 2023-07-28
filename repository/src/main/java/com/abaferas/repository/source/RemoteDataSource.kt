package com.abaferas.repository.source

import com.abaferas.repository.models.DTOArticleArchive
import com.abaferas.repository.models.DTOTopStories

interface RemoteDataSource {
    suspend fun getTopStoryBySection(section: String): DTOTopStories
}