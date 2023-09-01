package com.abaferas.usecase.repositories

import com.abaferas.entities.Article
import com.abaferas.entities.Books
import com.abaferas.entities.List
import com.abaferas.entities.MostPopularArticle
import com.abaferas.entities.TopStory

interface IRepository {
    suspend fun getArticleArchive(year: Int, month: Int): Article
    suspend fun getArticleSearch(query: String): Article
    suspend fun getBestSellerBooksHandCover(): Books
    suspend fun getBestSellerBooksEbook(): Books
    suspend fun getBookListOverView(publishedDate: String): List<Any?>
    suspend fun getListFullOverView(): List<Any?>
    suspend fun getMostPopular(period: Int): MostPopularArticle
    suspend fun getTopStories(section: String): TopStory
}