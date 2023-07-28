package com.abaferas.usecase.repositories

import com.abaferas.entities.TopStory

interface IRepositoryTopStory {
    suspend fun getTopStoryBySection(section: String):TopStory
}