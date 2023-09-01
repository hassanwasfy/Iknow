package com.abaferas.remote.retrofit

import com.abaferas.exception.IKnowException
import com.abaferas.remote.api.ApiService
import com.abaferas.repository.models.archive.DTOArticleArchive
import com.abaferas.repository.models.books.DTOBooks
import com.abaferas.repository.models.books.DTOListFullOverView
import com.abaferas.repository.models.books.DTOListOverView
import com.abaferas.repository.models.mostpopular.DTOMostPopularArticle
import com.abaferas.repository.models.search.DTOArticleSearch
import com.abaferas.repository.models.topstories.DTOTopStories
import com.abaferas.repository.source.RemoteDataSource
import retrofit2.Response
import java.net.UnknownHostException
import javax.inject.Inject

class RetrofitDataSource @Inject constructor(
    private val apiService: ApiService
):RemoteDataSource {
    override suspend fun getTopStoryBySection(section: String): DTOTopStories {
        return wrapBaseResponse {
            apiService.getTopStories(section = section)
        }
    }

    override suspend fun getArticleArchive(year: Int, month: Int): DTOArticleArchive {
        return wrapBaseResponse {
            apiService.getArticleArchive(year, month)
        }
    }

    override suspend fun getArticleSearch(query: String): DTOArticleSearch {
        return wrapBaseResponse {
            apiService.getArticleSearch(query)
        }
    }

    override suspend fun getBestSellerBooksHandCover(): DTOBooks {
        return wrapBaseResponse {
            apiService.getBestSellerBooks("hardcover-fiction")
        }
    }

    override suspend fun getBestSellerBooksEbook(): DTOBooks {
        return wrapBaseResponse {
            apiService.getBestSellerBooks("e-book-fiction")
        }
    }

    override suspend fun getBookListOverView(publishedDate: String): DTOListOverView {
        return wrapBaseResponse {
            apiService.getBookListOverView(publishedDate)
        }
    }

    override suspend fun getListFullOverView(): DTOListFullOverView {
        return wrapBaseResponse {
            apiService.getListFullOverView()
        }
    }

    override suspend fun getMostPopular(period: Int): DTOMostPopularArticle {
        return wrapBaseResponse {
            apiService.getMostPopular(period)
        }
    }

    override suspend fun getTopStories(section: String): DTOTopStories {
        return wrapBaseResponse {
            apiService.getTopStories(section)
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
                when (apiResponse.code()) {
                    429 -> {
                        throw IKnowException.TooManyRequests
                    }

                    401 -> {
                        throw IKnowException.NotAuthorized
                    }

                    400 -> {
                        throw IKnowException.BadRequest
                    }

                    else -> {
                        throw IKnowException.ServiceUnAvailable
                    }
                }
            }
        } catch (e: UnknownHostException) {
            throw IKnowException.NoInternetConnection
        }
    }
}