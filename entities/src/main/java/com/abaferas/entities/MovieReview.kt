package com.abaferas.entities

data class MovieReview(
    val hasMore: Boolean,
    val results: List<Result>
) {
    data class Result(
        val displayTitle: String,
        val mpaaRating: String,
        val criticsPick: Int,
        val byline: String,
        val headline: String,
        val summaryShort: String,
        val publicationDate: String,
        val openingDate: String,
        val dateUpdated: String,
        val link: String,
        val multimedia: Multimedia
    ) { data class Multimedia(
            val type: String,
            val src: String,
            val height: Int,
            val width: Int
        )
    }
}
