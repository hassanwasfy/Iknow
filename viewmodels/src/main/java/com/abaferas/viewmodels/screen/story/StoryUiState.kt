package com.abaferas.viewmodels.screen.story

import com.abaferas.entities.Story
import com.abaferas.entities.TopStories
import com.abaferas.viewmodels.base.BaseUiState
import com.abaferas.viewmodels.base.ErrorUiState

data class StoryUiState(
    val isLoading: Boolean = true,
    val isError: ErrorUiState? = null,
    val story: Story = Story()
) : BaseUiState

fun TopStories.TopStory.toUiState(): Story {
    return Story(
        section = this.section,
        title = this.title,
        abstract = this.abstract,
        url = this.url,
        byline = this.byLine,
        updatedDate = updatedDate,
        keyWords = this.desFacet.map {
            it.name
        },
        multimedia = this.multimedia.map {
            Story.Multimedia(it.url)
        },
        shortUrl = shortUrl
    )
}