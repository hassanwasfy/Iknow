package com.abaferas.iknow.di


/*@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): IKnowRoomDatabase {
        return Room.databaseBuilder(context, IKnowRoomDatabase::class.java, "iknow_database")
            .createFromAsset("iknow_database.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideArticleDao(database: IKnowRoomDatabase): EntityArticleDao {
        return database.articleDao()
    }

    @Singleton
    @Provides
    fun provideBooksDao(database: IKnowRoomDatabase): BooksEntityDao {
        return database.booksDao()
    }

    @Singleton
    @Provides
    fun provideArticleListDao(database: IKnowRoomDatabase): ArticleListDao {
        return database.articleListDao()
    }

    @Singleton
    @Provides
    fun provideMostPopularDao(database: IKnowRoomDatabase): MostPopularDao {
        return database.mostPopularDao()
    }

    @Singleton
    @Provides
    fun provideTopStoryDao(database: IKnowRoomDatabase): TopStoryDao {
        return database.topStoryDao()
    }

    @Singleton
    @Provides
    fun provideDatabaseDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}*/
