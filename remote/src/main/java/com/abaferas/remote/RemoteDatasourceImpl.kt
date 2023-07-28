package com.abaferas.remote

import com.abaferas.exception.IKnowException
import com.abaferas.remote.api.story.ServiceStories
import com.abaferas.repository.models.DTOTopStories
import com.abaferas.repository.source.RemoteDataSource
import retrofit2.Response
import java.net.ConnectException
import javax.inject.Inject

class RemoteDatasourceImpl @Inject constructor(
    private val serviceStories: ServiceStories
):RemoteDataSource {
    override suspend fun getTopStoryBySection(section: String): DTOTopStories {
        return wrapBaseResponse {
            serviceStories.getTopStories(section = section)
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
        } catch (e: ConnectException) {
            throw IKnowException.NoInternetConnection
        }
    }
}