package com.abaferas.repository.models.books


import com.google.gson.annotations.SerializedName

data class DTOBooks(
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("num_results")
    val numResults: Int?,
    @SerializedName("last_modified")
    val lastModified: String?,
    @SerializedName("results")
    val results: List<Result?>?
) {
    data class Result(
        @SerializedName("list_name")
        val listName: String?,
        @SerializedName("display_name")
        val displayName: String?,
        @SerializedName("bestsellers_date")
        val bestsellersDate: String?,
        @SerializedName("published_date")
        val publishedDate: String?,
        @SerializedName("rank")
        val rank: Int?,
        @SerializedName("rank_last_week")
        val rankLastWeek: Int?,
        @SerializedName("weeks_on_list")
        val weeksOnList: Int?,
        @SerializedName("asterisk")
        val asterisk: Int?,
        @SerializedName("dagger")
        val dagger: Int?,
        @SerializedName("amazon_product_url")
        val amazonProductUrl: String?,
        @SerializedName("isbns")
        val isbns: List<Isbn?>?,
        @SerializedName("book_details")
        val bookDetails: List<BookDetail?>?,
        @SerializedName("reviews")
        val reviews: List<Review?>?
    ) {
        data class Isbn(
            @SerializedName("isbn10")
            val isbn10: String?,
            @SerializedName("isbn13")
            val isbn13: String?
        )

        data class BookDetail(
            @SerializedName("title")
            val title: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("contributor")
            val contributor: String?,
            @SerializedName("author")
            val author: String?,
            @SerializedName("contributor_note")
            val contributorNote: String?,
            @SerializedName("price")
            val price: String?,
            @SerializedName("age_group")
            val ageGroup: String?,
            @SerializedName("publisher")
            val publisher: String?,
            @SerializedName("primary_isbn13")
            val primaryIsbn13: String?,
            @SerializedName("primary_isbn10")
            val primaryIsbn10: String?
        )

        data class Review(
            @SerializedName("book_review_link")
            val bookReviewLink: String?,
            @SerializedName("first_chapter_link")
            val firstChapterLink: String?,
            @SerializedName("sunday_review_link")
            val sundayReviewLink: String?,
            @SerializedName("article_chapter_link")
            val articleChapterLink: String?
        )
    }
}