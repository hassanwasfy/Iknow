package com.abaferas.usecase.usecase

import com.abaferas.entities.TopStories
import com.abaferas.usecase.repositories.IRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetSingleStoryByIdUseCase @Inject constructor(
    private val iRepository: IRepository
) {
    suspend operator fun invoke(section: String, id: String): TopStories = coroutineScope {
        try {
            val list: MutableList<TopStories.TopStory> = mutableListOf()
            section.split(",").forEach {
                launch {
                    list += iRepository.getTopStories(it).results
                }
            }
            TopStories(
                results = list.filter {
                    it.title == id
                }
            )
        } catch (e: Exception) {
            throw e
        }
    }
}