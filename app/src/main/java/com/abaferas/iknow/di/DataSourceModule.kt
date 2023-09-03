package com.abaferas.iknow.di

import com.abaferas.local.room.RoomDataSource
import com.abaferas.remote.retrofit.RetrofitDataSource
import com.abaferas.repository.source.LocalDataSource
import com.abaferas.repository.source.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindLocalDataSource(retrofitDataSource: RetrofitDataSource): RemoteDataSource

    @Binds
    abstract fun provideRoomSource(roomDataSource: RoomDataSource): LocalDataSource
}