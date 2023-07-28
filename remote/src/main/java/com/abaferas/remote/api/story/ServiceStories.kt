package com.abaferas.remote.api.story

import com.abaferas.remote.BuildConfig
import com.abaferas.repository.models.DTOTopStories
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceStories {
    @GET("articles")
    suspend fun getTopStories(
        @Query(BuildConfig.API_QUERY) apiKey: String = BuildConfig.API_KEY,
        @Query("section") section: String
    ): Response<DTOTopStories>
}