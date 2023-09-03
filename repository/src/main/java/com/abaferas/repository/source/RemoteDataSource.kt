package com.abaferas.repository.source

import com.abaferas.repository.models.dto.archive.DTOArticleArchive
import com.abaferas.repository.models.dto.books.DTOBooks
import com.abaferas.repository.models.dto.books.DTOListFullOverView
import com.abaferas.repository.models.dto.books.DTOListOverView
import com.abaferas.repository.models.dto.mostpopular.DTOMostPopularArticle
import com.abaferas.repository.models.dto.search.DTOArticleSearch
import com.abaferas.repository.models.dto.topstories.DTOTopStories

interface RemoteDataSource {
    suspend fun getTopStoryBySection(section: String): DTOTopStories
    suspend fun getArticleArchive(year: Int, month: Int): DTOArticleArchive
    suspend fun getArticleSearch(query: String): DTOArticleSearch
    suspend fun getBestSellerBooksHandCover(): DTOBooks
    suspend fun getBestSellerBooksEbook(): DTOBooks

    suspend fun getBookListOverView(publishedDate: String): DTOListOverView
    suspend fun getListFullOverView(): DTOListFullOverView
    suspend fun getMostPopular(period: Int = 30): DTOMostPopularArticle
    suspend fun getTopStories(section: String): DTOTopStories
}