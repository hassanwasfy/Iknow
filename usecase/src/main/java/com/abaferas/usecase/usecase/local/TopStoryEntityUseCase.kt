package com.abaferas.usecase.usecase.local

import com.abaferas.entities.TopStories
import com.abaferas.usecase.repositories.ILocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class TopStoryEntityUseCase @Inject constructor(
    private val localRepository: ILocalRepository
) {

    suspend fun insertArticle(article: TopStories) {
        localRepository.insertTopStory(article)
    }

    suspend fun deleteArticle(article: TopStories) {
        localRepository.deleteTopStory(article)
    }

    fun getAllArticles(): Flow<List<TopStories>> {
        return localRepository.getAllTopStories()
    }

    suspend fun getArticleById(id: Long): TopStories {
        return localRepository.getTopStoryById(id).single()
    }
}