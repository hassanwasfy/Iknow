package com.abaferas.usecase.usecase

import com.abaferas.entities.TopStory
import com.abaferas.exception.IKnowException
import com.abaferas.usecase.repositories.IRepositoryTopStory
import javax.inject.Inject

class GetTopStoriesBySectionUseCase @Inject constructor(
    private val iRepositoryTopStory: IRepositoryTopStory
)  {
    suspend operator fun invoke(section: String): TopStory {
        return try {
            iRepositoryTopStory.getTopStoryBySection(section)
        }catch (iKnowException: IKnowException){
            throw iKnowException
        }
    }
}