package com.abaferas.iknow.di

import com.abaferas.repository.repositories.IRepositoryTopStoryImpl
import com.abaferas.usecase.IRepositoryTopStory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindLocalDataSource(
        iRepositoryTopStoryImpl: IRepositoryTopStoryImpl
    ): IRepositoryTopStory


}