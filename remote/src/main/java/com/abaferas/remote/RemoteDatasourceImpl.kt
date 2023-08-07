package com.abaferas.remote

import com.abaferas.exception.IKnowException
import com.abaferas.remote.api.ApiService
import com.abaferas.repository.models.DTOMovieReview
import com.abaferas.repository.models.DTOTopStories
import com.abaferas.repository.source.RemoteDataSource
import retrofit2.Response
import java.net.UnknownHostException
import javax.inject.Inject

class RemoteDatasourceImpl @Inject constructor(
    private val apiService: ApiService
):RemoteDataSource {
    override suspend fun getTopStoryBySection(section: String): DTOTopStories {
        return wrapBaseResponse {
            apiService.getTopStories(section = section)
        }
    }

    override suspend fun searchMoviesReviews(query: String): DTOMovieReview {
        return wrapBaseResponse {
            apiService.searchMoviesReviews(query = query)
        }
    }


    private suspend fun <T> wrapBaseResponse(
        response: suspend () -> Response<T>
    ): T {
        return try {
            val apiResponse = response()
            if (apiResponse.isSuccessful) {
                apiResponse.body() ?: throw IKnowException.NullResponseBody
            } else {
                when(apiResponse.code()){
                    429 -> {throw IKnowException.TooManyRequests}
                    401 -> {throw IKnowException.NotAuthorized}
                    else -> {throw IKnowException.ServiceUnAvailable}
                }
            }
        } catch (e: UnknownHostException) {
            throw IKnowException.NoInternetConnection
        }
    }
}