package com.abaferas.usecase.repositories

import com.abaferas.entities.MovieReview

interface IRepositoryMovies {
    suspend fun searchMoviesReviews(query: String): MovieReview
}