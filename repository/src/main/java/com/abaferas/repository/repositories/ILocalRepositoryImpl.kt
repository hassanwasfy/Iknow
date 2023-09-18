package com.abaferas.repository.repositories

/*
class ILocalRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : ILocalRepository {

    override suspend fun insertArticle(article: Article) {
        val articleEntity = article.docs[0].toArticleEntity()
        localDataSource.insertArticle(articleEntity)
    }

    override suspend fun deleteArticle(article: Article) {
        localDataSource.deleteArticle(article.docs[0].toArticleEntity())
    }

    override fun getAllArticles(): Flow<List<Article>> {
        return localDataSource.getAllArticles().map { articleEntities ->
            articleEntities.map { it.toArticle() }
        }
    }

    override suspend fun getArticleById(id: Long): Flow<Article> {
        return localDataSource.getArticleById(id.toString()).map { it.toArticle() }
    }

    override suspend fun insertBook(books: Books) {
        val booksEntity = books.toBooksEntity()
        localDataSource.insertBook(booksEntity)
    }

    override suspend fun deleteBook(books: Books) {
        localDataSource.deleteBook(books.toBooksEntity())
    }

    override fun getAllBooks(): Flow<List<Books>> {
        return localDataSource.getAllBooks().map { booksEntities ->
            booksEntities.map { it.toBooks() }
        }
    }

    override suspend fun getBookById(id: Long): Flow<Books> {
        return localDataSource.getBookById(id).map { it.toBooks() }
    }

    override suspend fun insertArticleList(articleList: ArticleList) {
        val articleListEntity = articleList.toArticleListEntity()
        localDataSource.insertArticleList(articleListEntity)
    }

    override suspend fun deleteArticleList(articleList: ArticleList) {
        localDataSource.deleteArticleList(articleList.toArticleListEntity())
    }

    override fun getAllArticleLists(): Flow<List<ArticleList>> {
        return localDataSource.getAllArticleLists().map { articleListEntities ->
            articleListEntities.map { it.toArticleList() }
        }
    }

    override suspend fun getArticleListById(id: Long): Flow<ArticleList> {
        return localDataSource.getArticleListById(id).map { it.toArticleList() }
    }

    override suspend fun insertMostPopularArticle(mostPopularArticle: MostPopularArticle) {
        val mostPopularArticleEntity = mostPopularArticle.toMostPopularArticleEntity()
        localDataSource.insertMostPopularArticle(mostPopularArticleEntity)
    }

    override suspend fun deleteMostPopularArticle(mostPopularArticle: MostPopularArticle) {
        localDataSource.deleteMostPopularArticle(mostPopularArticle.toMostPopularArticleEntity())
    }

    override fun getAllMostPopularArticles(): Flow<List<MostPopularArticle>> {
        return localDataSource.getAllMostPopularArticles().map { mostPopularArticleEntities ->
            mostPopularArticleEntities.map { it.toMostPopularArticle() }
        }
    }

    override suspend fun getMostPopularArticleById(id: Long): Flow<MostPopularArticle> {
        return localDataSource.getMostPopularArticleById(id).map { it.toMostPopularArticle() }
    }

    override suspend fun insertTopStory(topStories: TopStories) {
        val topStoriesEntity = topStories.toTopStoriesEntity()
        localDataSource.insertTopStory(topStoriesEntity)
    }

    override suspend fun deleteTopStory(topStories: TopStories) {
        localDataSource.deleteTopStory(topStories.toTopStoriesEntity())
    }

    override fun getAllTopStories(): Flow<List<TopStories>> {
        return localDataSource.getAllTopStories().map { topStoriesEntities ->
            topStoriesEntities.map { it.toTopStories() }
        }
    }

    override suspend fun getTopStoryById(id: Long): Flow<TopStories> {
        return localDataSource.getTopStoryById(id).map { it.toTopStories() }
    }
}
*/
