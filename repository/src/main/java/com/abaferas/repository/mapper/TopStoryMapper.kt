package com.abaferas.repository.mapper

import com.abaferas.entities.TopStories
import com.abaferas.repository.models.entity.KMultimedia
import com.abaferas.repository.models.entity.KTopStory
import com.abaferas.repository.models.entity.KWord
import com.abaferas.repository.models.entity.TopStoriesEntity

fun TopStories.toTopStoriesEntity(): TopStoriesEntity {
    val topStoriesEntity = TopStoriesEntity()
    topStoriesEntity.results = this.results.map { topStory ->
        val kTopStory = KTopStory(
            section = topStory.section,
            subsection = topStory.subsection,
            `abstract` = topStory.`abstract`,
            title = topStory.title,
            url = topStory.url,
            byLine = topStory.byLine,
            updatedDate = topStory.updatedDate,
            createdDate = topStory.createdDate,
            publishedDate = topStory.publishedDate,
            kicker = topStory.kicker
        )

        kTopStory.desFacet = topStory.desFacet.map { word ->
            KWord(name = word.name)
        }

        kTopStory.multimedia = topStory.multimedia.map { media ->
            KMultimedia(url = media.url)
        }

        kTopStory
    }
    return topStoriesEntity
}


fun TopStoriesEntity.toTopStories(): TopStories {
    val topStories = TopStories(
        results = this.results.map { kTopStory ->
            TopStories.TopStory(
                section = kTopStory.section,
                subsection = kTopStory.subsection,
                `abstract` = kTopStory.`abstract`,
                title = kTopStory.title,
                url = kTopStory.url,
                byLine = kTopStory.byLine,
                updatedDate = kTopStory.updatedDate,
                createdDate = kTopStory.createdDate,
                publishedDate = kTopStory.publishedDate,
                desFacet = kTopStory.desFacet.map { kWord ->
                    TopStories.TopStory.Word(name = kWord.name)
                },
                kicker = kTopStory.kicker,
                multimedia = kTopStory.multimedia.map { kMultimedia ->
                    TopStories.TopStory.Multimedia(url = kMultimedia.url)
                },
                shortUrl = ""
            )
        }
    )
    return topStories
}


