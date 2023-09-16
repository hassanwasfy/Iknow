package com.abaferas.repository.mapper

import com.abaferas.entities.Story
import com.abaferas.repository.models.entity.StoryEntity

fun Story.toStoryEntity(): StoryEntity {
    val storyEntity = StoryEntity(
        section = this.section,
        title = this.title,
        `abstract` = this.`abstract`,
        url = this.url,
        byline = this.byline,
        updatedDate = this.updatedDate,
        shortUrl = this.shortUrl
    )

    storyEntity.keyWords = this.keyWords.map { keyword ->
        StoryEntity.SKeyword(name = keyword)
    }

    storyEntity.multimedia = this.multimedia.map { media ->
        StoryEntity.SMultimedia(url = media.url)
    }

    return storyEntity
}


fun StoryEntity.toStory(): Story {
    val story = Story(
        section = this.section,
        title = this.title,
        `abstract` = this.`abstract`,
        url = this.url,
        byline = this.byline,
        updatedDate = this.updatedDate,
        shortUrl = this.shortUrl
    )

    story.keyWords = this.keyWords.map { keyword ->
        keyword.name
    }

    story.multimedia = this.multimedia.map { media ->
        Story.Multimedia(url = media.url)
    }

    return story
}

