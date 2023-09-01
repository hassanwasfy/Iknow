package com.abaferas.iknow.di

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