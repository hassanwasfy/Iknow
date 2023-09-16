package com.abaferas.repository.models.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class TopStoriesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
) {
    @Embedded
    var results: List<KTopStory> = emptyList()
}

@Entity
data class KTopStory(
    @PrimaryKey(autoGenerate = true)
    var topStoryId: Long = 0L,
    var section: String = "",
    var subsection: String = "",
    var `abstract`: String = "",
    var title: String = "",
    var url: String = "",
    var byLine: String = "",
    var updatedDate: String = "",
    var createdDate: String = "",
    var publishedDate: String = "",
    @Embedded
    var desFacet: List<KWord> = emptyList(),
    var kicker: String = ""
) {
    @Relation(
        parentColumn = "topStoryId",
        entityColumn = "topStoryOwnerId"
    )
    var multimedia: List<KMultimedia> = emptyList()
}

@Entity
data class KMultimedia(
    @PrimaryKey(autoGenerate = true)
    var multimediaId: Long = 0L,
    var url: String = "",
    var topStoryOwnerId: Long = 0L
)

@Entity
data class KWord(
    @PrimaryKey(autoGenerate = true)
    var wordId: Long = 0L,
    var name: String = ""
)


