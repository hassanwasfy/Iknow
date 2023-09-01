package com.abaferas.repository.mapper

import com.abaferas.entities.TopStory
import com.abaferas.repository.models.topstories.DTOTopStories


fun DTOTopStories.toDomain(): TopStory {
    val topStoriesList = this.results?.map { dtoTopStories ->
        dtoTopStories.multimedia?.let {
            TopStory.TopStories(
                section = dtoTopStories.section ?: "N/A",
                subsection = dtoTopStories.subsection ?: "N/A",
                title = dtoTopStories.title ?: "N/A",
                url = dtoTopStories.url ?: "N/A",
                updatedDate = dtoTopStories.updatedDate ?: "N/A",
                createdDate = dtoTopStories.createdDate ?: "N/A",
                publishedDate = dtoTopStories.publishedDate ?: "N/A",
                kicker = dtoTopStories.kicker ?: "N/A",
                multimedia = it.map { dtoMultimedia ->
                    TopStory.TopStories.Multimedia(
                        url = dtoMultimedia.url ?: "N/A",
                        format = dtoMultimedia.format ?: "N/A",
                        height = dtoMultimedia.height ?: 0,
                        width = dtoMultimedia.width ?: 0,
                        type = dtoMultimedia.type ?: "N/A",
                        subtype = dtoMultimedia.subtype ?: "N/A",
                        caption = dtoMultimedia.caption ?: "N/A",
                        copyright = dtoMultimedia.copyright ?: "N/A"
                    )
                },
                shortUrl = dtoTopStories.shortUrl ?: "N/A"
            )
        } ?: emptyList<DTOTopStories.TopStories>()
    }

    return TopStory(
        copyright = this.copyright ?: "N/A",
        lastUpdated = this.lastUpdated ?: "N/A",
        results = requireNotNull(topStoriesList as List<TopStory.TopStories>)
    )
}
