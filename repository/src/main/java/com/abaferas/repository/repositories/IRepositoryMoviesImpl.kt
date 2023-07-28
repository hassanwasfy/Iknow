package com.abaferas.repository.repositories

import com.abaferas.entities.MovieReview
import com.abaferas.repository.mapper.toMovieReview
import com.abaferas.repository.source.RemoteDataSource
import com.abaferas.usecase.repositories.IRepositoryMovies
import javax.inject.Inject

class IRepositoryMoviesImpl @Inject constructor (
    private val remoteDataSource: RemoteDataSource
): IRepositoryMovies {
    override suspend fun searchMoviesReviews(query: String): MovieReview {
        return remoteDataSource.searchMoviesReviews(query = query).toMovieReview()
    }
}