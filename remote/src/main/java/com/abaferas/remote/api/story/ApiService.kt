package com.abaferas.remote.api.story

import com.abaferas.remote.BuildConfig
import com.abaferas.repository.models.DTOMovieReview
import com.abaferas.repository.models.DTOTopStories
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("{section}.json")
    suspend fun getTopStories(
        @Path("section") section: String,
        @Query(BuildConfig.API_QUERY) apiKey: String = BuildConfig.API_KEY
    ): Response<DTOTopStories>

    @GET("search.json")
    suspend fun searchMoviesReviews(
        @Query("offset") offset:Int = 0,
        @Query("query") query: String,
        @Query(BuildConfig.API_QUERY) apiKey: String = BuildConfig.API_KEY
    ):Response<DTOMovieReview>
}