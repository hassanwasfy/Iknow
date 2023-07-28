package com.abaferas.repository.mapper

import com.abaferas.entities.MovieReview
import com.abaferas.repository.models.DTOMovieReview

fun DTOMovieReview.toMovieReview(): MovieReview{
    return MovieReview(
        hasMore = requireNotNull(this.hasMore),
        results = this.results!!.map {
            MovieReview.Result(
                displayTitle = it.displayTitle ?: "N/A",
                mpaaRating = it.mpaaRating ?: "N/A",
                criticsPick = it.criticsPick  ?: 0,
                byline = it.byline  ?: "N/A",
                summaryShort = it.summaryShort  ?: "N/A",
                headline = it.headline  ?: "N/A",
                publicationDate = it.publicationDate  ?: "N/A",
                openingDate = it.openingDate  ?: "N/A",
                dateUpdated = it.dateUpdated ?: "N/A",
                link = it.link!!.url  ?: "N/A",
                multimedia = it.multimedia as MovieReview.Result.Multimedia
            )
        }
    )
}