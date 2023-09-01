package com.abaferas.iknow.di

import com.abaferas.repository.repositories.IRepositoryImpl
import com.abaferas.usecase.repositories.IRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun provideTopStory(
        iRepositoryImpl: IRepositoryImpl
    ): IRepository

}