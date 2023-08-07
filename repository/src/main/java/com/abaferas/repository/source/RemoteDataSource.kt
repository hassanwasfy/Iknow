package com.abaferas.repository.source

import com.abaferas.repository.models.DTOArticleArchive
import com.abaferas.repository.models.DTOMovieReview
import com.abaferas.repository.models.DTOTopStories

interface RemoteDataSource {

    //region Archive
    //endregion

    //region Search
    //endregion

    //region Books
    //endregion

    //region Movies
    suspend fun searchMoviesReviews(query: String):DTOMovieReview
    //endregion

    //region Most Popular
    //endregion

    //region Wire
    //endregion

    //region TopStories
    suspend fun getTopStoryBySection(section: String): DTOTopStories
    //endregion
}