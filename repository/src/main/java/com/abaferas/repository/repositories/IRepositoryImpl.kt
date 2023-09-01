package com.abaferas.repository.repositories

import com.abaferas.entities.Article
import com.abaferas.entities.Books
import com.abaferas.entities.List
import com.abaferas.entities.MostPopularArticle
import com.abaferas.entities.TopStory
import com.abaferas.repository.mapper.toDomain
import com.abaferas.repository.source.RemoteDataSource
import com.abaferas.usecase.repositories.IRepository
import javax.inject.Inject

class IRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : IRepository {

    override suspend fun getArticleArchive(year: Int, month: Int): Article {
        return remoteDataSource.getArticleArchive(year, month).toDomain()
    }

    override suspend fun getArticleSearch(query: String): Article {
        return remoteDataSource.getArticleSearch(query).toDomain()
    }

    override suspend fun getBestSellerBooksHandCover(): Books {
        return remoteDataSource.getBestSellerBooksHandCover().toDomain()
    }

    override suspend fun getBestSellerBooksEbook(): Books {
        return remoteDataSource.getBestSellerBooksEbook().toDomain()
    }

    override suspend fun getBookListOverView(publishedDate: String): List<Any?> {
        return remoteDataSource.getBookListOverView(publishedDate).toDomain()
    }

    override suspend fun getListFullOverView(): List<Any?> {
        return remoteDataSource.getListFullOverView().toDomain()
    }

    override suspend fun getMostPopular(period: Int): MostPopularArticle {
        return remoteDataSource.getMostPopular(period).toDomain()
    }

    override suspend fun getTopStories(section: String): TopStory {
        return remoteDataSource.getTopStories(section).toDomain()
    }
}