package com.abaferas.usecase.usecase.local

import com.abaferas.entities.Article
import com.abaferas.usecase.repositories.ILocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class ArticleEntityUseCase @Inject constructor(
    private val localRepository: ILocalRepository
) {

    suspend fun insertArticle(article: Article) {
        localRepository.insertArticle(article)
    }

    suspend fun deleteArticle(article: Article) {
        localRepository.deleteArticle(article)
    }

    fun getAllArticles(): Flow<List<Article>> {
        return localRepository.getAllArticles()
    }

    suspend fun getArticleById(id: Long): Article {
        return localRepository.getArticleById(id).single()
    }
}