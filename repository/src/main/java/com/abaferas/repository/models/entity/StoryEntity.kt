package com.abaferas.repository.models.entity


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class StoryEntity(
    @PrimaryKey(autoGenerate = true)
    var storyId: Long = 0L,
    var section: String = "",
    var title: String = "",
    var `abstract`: String = "",
    var url: String = "",
    var byline: String = "",
    var updatedDate: String = "",
    @Relation(
        parentColumn = "storyId",
        entityColumn = "storyOwnerId"
    )
    var keyWords: List<SKeyword> = emptyList(),
    @Embedded
    var multimedia: List<SMultimedia> = emptyList(),
    var shortUrl: String = ""
) {
    @Entity
    data class SKeyword(
        @PrimaryKey(autoGenerate = true)
        var keywordId: Long = 0L,
        var name: String = "",
        var storyOwnerId: Long = 0L
    )

    @Entity
    data class SMultimedia(
        @PrimaryKey(autoGenerate = true)
        var multimediaId: Long = 0L,
        var url: String = "",
        var storyOwnerId: Long = 0L
    )
}



