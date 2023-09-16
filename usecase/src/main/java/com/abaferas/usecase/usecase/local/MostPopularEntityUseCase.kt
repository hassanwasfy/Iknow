package com.abaferas.usecase.usecase.local

import com.abaferas.entities.MostPopularArticle
import com.abaferas.usecase.repositories.ILocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class MostPopularEntityUseCase @Inject constructor(
    private val localRepository: ILocalRepository
) {

    suspend fun insertArticle(article: MostPopularArticle) {
        localRepository.insertMostPopularArticle(article)
    }

    suspend fun deleteArticle(article: MostPopularArticle) {
        localRepository.deleteMostPopularArticle(article)
    }

    fun getAllArticles(): Flow<List<MostPopularArticle>> {
        return localRepository.getAllMostPopularArticles()
    }

    suspend fun getArticleById(id: Long): MostPopularArticle {
        return localRepository.getMostPopularArticleById(id).single()
    }
}