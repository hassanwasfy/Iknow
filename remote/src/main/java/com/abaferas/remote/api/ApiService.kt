package com.abaferas.remote.api

import com.abaferas.remote.BuildConfig
import com.abaferas.repository.models.archive.DTOArticleArchive
import com.abaferas.repository.models.search.DTOArticleSearch
import com.abaferas.repository.models.DTOMostPopularArticle
import com.abaferas.repository.models.DTOMovieReview
import com.abaferas.repository.models.DTOTopStories
import com.abaferas.repository.models.books.DTOBooks
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // region Archive
    @GET("archive/v1/{year}/{month}.json")
    suspend fun getArticleArchive(
        @Path("year") year: Int, // 1851 - 2019
        @Path("month") month: Int, // 1 - 12
        @Query(BuildConfig.API_QUERY) apiKey: String = BuildConfig.API_KEY
    ): Response<DTOArticleArchive>
    // endregion

    //region Search
    @GET("search/v2/articlesearch.json")
    suspend fun getArticleSearch(
        @Query("q") query: String,
        @Query(BuildConfig.API_QUERY) apiKey: String = BuildConfig.API_KEY
    ): Response<DTOArticleSearch>
    //endregion

    //region Books
    //books/v3/lists.json
    @GET("")
    suspend fun getBestSellerBooks(
        @Query("list") bookType: String = "hardcover-fiction", /* TODO e-book-fiction*/
        @Query(BuildConfig.API_QUERY) apiKey: String = BuildConfig.API_KEY
    ):Response<DTOBooks>
    //endregion

    // region Movies Reviews
    @GET("search.json")
    suspend fun searchMoviesReviews(
        @Query("offset") offset:Int = 0,
        @Query("query") query: String,
        @Query(BuildConfig.API_QUERY) apiKey: String = BuildConfig.API_KEY
    ):Response<DTOMovieReview>
    // endregion

    // region Most Popular
    @GET("mostpopular/v2/viewed/{period}.json")
    suspend fun getMostPopular(
        @Path("period") period: Int = 30, // 1 - 7 - 30
        @Query(BuildConfig.API_QUERY) apiKey: String = BuildConfig.API_KEY
    ): Response<DTOMostPopularArticle>
    // endregion

    // region Top Stories
    @GET("topstories/v2/{section}.json")
    suspend fun getTopStories(
        @Path("section") section: String,
        @Query(BuildConfig.API_QUERY) apiKey: String = BuildConfig.API_KEY
    ): Response<DTOTopStories>
    // endregion


}