package com.abaferas.repository.mapper

import com.abaferas.entities.TopStory
import com.abaferas.repository.models.DTOTopStories


fun List<DTOTopStories>.toDomain():List<TopStory>{
    return this.map {
        it.toTopStory()
    }
}
fun DTOTopStories.toTopStory(): TopStory {
    val topStoriesList = this.results.map { dtoTopStories ->
        TopStory.TopStories(
            section = dtoTopStories.section,
            subsection = dtoTopStories.subsection,
            title = dtoTopStories.title,
            url = dtoTopStories.url,
            updatedDate = dtoTopStories.updatedDate,
            createdDate = dtoTopStories.createdDate,
            publishedDate = dtoTopStories.publishedDate,
            kicker = dtoTopStories.kicker,
            multimedia = dtoTopStories.multimedia.map { dtoMultimedia ->
                TopStory.TopStories.Multimedia(
                    url = dtoMultimedia.url,
                    format = dtoMultimedia.format,
                    height = dtoMultimedia.height,
                    width = dtoMultimedia.width,
                    type = dtoMultimedia.type,
                    subtype = dtoMultimedia.subtype,
                    caption = dtoMultimedia.caption,
                    copyright = dtoMultimedia.copyright
                )
            },
            shortUrl = dtoTopStories.shortUrl
        )
    }

    return TopStory(
        copyright = this.copyright,
        lastUpdated = this.lastUpdated,
        results = topStoriesList
    )
}