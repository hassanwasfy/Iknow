package com.abaferas.usecase.usecase.local

import com.abaferas.entities.ArticleList
import com.abaferas.usecase.repositories.ILocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class ArticleListEntityUseCase @Inject constructor(
    private val localRepository: ILocalRepository
) {

    suspend fun insertArticle(article: ArticleList) {
        localRepository.insertArticleList(article)
    }

    suspend fun deleteArticle(article: ArticleList) {
        localRepository.deleteArticleList(article)
    }

    fun getAllArticles(): Flow<List<ArticleList>> {
        return localRepository.getAllArticleLists()
    }

    suspend fun getArticleById(id: Long): ArticleList {
        return localRepository.getArticleListById(id).single()
    }
}