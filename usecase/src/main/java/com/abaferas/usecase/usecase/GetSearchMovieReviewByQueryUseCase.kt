package com.abaferas.usecase.usecase

import com.abaferas.entities.MovieReview
import com.abaferas.exception.IKnowException
import com.abaferas.usecase.repositories.IRepositoryMovies
import javax.inject.Inject

class GetSearchMovieReviewByQueryUseCase @Inject constructor(
    private val iRepositoryMovies: IRepositoryMovies
)  {
    suspend operator fun invoke(query: String): MovieReview {
        return try {
            iRepositoryMovies.searchMoviesReviews(query)
        }catch (iKnowException: IKnowException){
            throw iKnowException
        }
    }
}