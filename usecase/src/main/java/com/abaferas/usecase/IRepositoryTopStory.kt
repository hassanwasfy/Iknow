package com.abaferas.usecase

import com.abaferas.entities.TopStory

interface IRepositoryTopStory {
    suspend fun getTopStoryBySection(section: String):TopStory
}