package com.abaferas.usecase.repositories

import com.abaferas.entities.Article
import com.abaferas.entities.ArticleList
import com.abaferas.entities.Books
import com.abaferas.entities.MostPopularArticle
import com.abaferas.entities.TopStories

interface IRepository {
    suspend fun getArticleArchive(year: Int, month: Int): Article
    suspend fun getArticleSearch(query: String): Article
    suspend fun getBestSellerBooksHandCover(): Books
    suspend fun getBestSellerBooksEbook(): Books
    suspend fun getBookListOverView(publishedDate: String): ArticleList
    suspend fun getListFullOverView(): ArticleList
    suspend fun getMostPopular(period: Int): MostPopularArticle
    suspend fun getTopStories(section: String): TopStories
}