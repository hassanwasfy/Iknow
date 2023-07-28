package com.abaferas.iknow.di

import com.abaferas.repository.repositories.IRepositoryMoviesImpl
import com.abaferas.repository.repositories.IRepositoryTopStoryImpl
import com.abaferas.usecase.repositories.IRepositoryMovies
import com.abaferas.usecase.repositories.IRepositoryTopStory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun provideTopStory(
        iRepositoryTopStoryImpl: IRepositoryTopStoryImpl
    ): IRepositoryTopStory

    @Binds
    abstract fun provideMovies(
        iRepositoryMoviesImpl: IRepositoryMoviesImpl
    ): IRepositoryMovies


}