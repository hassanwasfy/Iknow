package com.abaferas.iknow.di

import com.abaferas.remote.RemoteDatasourceImpl
import com.abaferas.repository.source.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindLocalDataSource(remoteDatasourceImpl: RemoteDatasourceImpl): RemoteDataSource
}