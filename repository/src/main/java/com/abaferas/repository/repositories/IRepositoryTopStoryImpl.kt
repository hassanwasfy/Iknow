package com.abaferas.repository.repositories

import com.abaferas.entities.TopStory
import com.abaferas.repository.mapper.toTopStory
import com.abaferas.repository.source.RemoteDataSource
import com.abaferas.usecase.repositories.IRepositoryTopStory
import javax.inject.Inject

class IRepositoryTopStoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : IRepositoryTopStory {
    override suspend fun getTopStoryBySection(section: String): TopStory {
        return remoteDataSource.getTopStoryBySection(section).toTopStory()
    }
}