package com.abaferas.repository.models.books


import com.google.gson.annotations.SerializedName

data class DTOListOverView(
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("num_results")
    val numResults: Int?,
    @SerializedName("results")
    val results: Results?
) {
    data class Results(
        @SerializedName("bestsellers_date")
        val bestsellersDate: String?,
        @SerializedName("published_date")
        val publishedDate: String?,
        @SerializedName("published_date_description")
        val publishedDateDescription: String?,
        @SerializedName("previous_published_date")
        val previousPublishedDate: String?,
        @SerializedName("next_published_date")
        val nextPublishedDate: String?,
        @SerializedName("lists")
        val lists: List<Lists?>?
    ) {
        data class Lists(
            @SerializedName("list_id")
            val listId: Int?,
            @SerializedName("list_name")
            val listName: String?,
            @SerializedName("list_name_encoded")
            val listNameEncoded: String?,
            @SerializedName("display_name")
            val displayName: String?,
            @SerializedName("updated")
            val updated: String?,
            @SerializedName("list_image")
            val listImage: Any?,
            @SerializedName("list_image_width")
            val listImageWidth: Any?,
            @SerializedName("list_image_height")
            val listImageHeight: Any?,
            @SerializedName("books")
            val books: List<Book?>?
        ) {
            data class Book(
                @SerializedName("age_group")
                val ageGroup: String?,
                @SerializedName("amazon_product_url")
                val amazonProductUrl: String?,
                @SerializedName("article_chapter_link")
                val articleChapterLink: String?,
                @SerializedName("author")
                val author: String?,
                @SerializedName("book_image")
                val bookImage: String?,
                @SerializedName("book_image_width")
                val bookImageWidth: Int?,
                @SerializedName("book_image_height")
                val bookImageHeight: Int?,
                @SerializedName("book_review_link")
                val bookReviewLink: String?,
                @SerializedName("contributor")
                val contributor: String?,
                @SerializedName("contributor_note")
                val contributorNote: String?,
                @SerializedName("created_date")
                val createdDate: String?,
                @SerializedName("description")
                val description: String?,
                @SerializedName("first_chapter_link")
                val firstChapterLink: String?,
                @SerializedName("price")
                val price: String?,
                @SerializedName("primary_isbn10")
                val primaryIsbn10: String?,
                @SerializedName("primary_isbn13")
                val primaryIsbn13: String?,
                @SerializedName("book_uri")
                val bookUri: String?,
                @SerializedName("publisher")
                val publisher: String?,
                @SerializedName("rank")
                val rank: Int?,
                @SerializedName("rank_last_week")
                val rankLastWeek: Int?,
                @SerializedName("sunday_review_link")
                val sundayReviewLink: String?,
                @SerializedName("title")
                val title: String?,
                @SerializedName("updated_date")
                val updatedDate: String?,
                @SerializedName("weeks_on_list")
                val weeksOnList: Int?,
                @SerializedName("buy_links")
                val buyLinks: List<BuyLink?>?
            ) {
                data class BuyLink(
                    @SerializedName("name")
                    val name: String?,
                    @SerializedName("url")
                    val url: String?
                )
            }
        }
    }
}