package com.abaferas.usecase.usecase

import com.abaferas.entities.TopStories
import com.abaferas.usecase.repositories.IRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetTopStoriesBySectionUseCase @Inject constructor(
    private val iRepository: IRepository
) {
    suspend operator fun invoke(section: String): TopStories = coroutineScope {
        try {
            val list: MutableList<TopStories.TopStory> = mutableListOf()
            section.split(",").forEach {
                launch {
                    list += iRepository.getTopStories(it).results
                }
            }
            TopStories(
                results = list
            )
        } catch (e: Exception) {
            throw e
        }
    }
}