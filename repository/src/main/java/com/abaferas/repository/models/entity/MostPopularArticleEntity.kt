package com.abaferas.repository.models.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class MostPopularArticleEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
) {
    @Embedded
    var results: List<VResult> = emptyList()
}

@Entity
data class VResult(
    @PrimaryKey(autoGenerate = true)
    var resultId: Long = 0L,
    var url: String = "",
    var idR: Long = 0L,
    var source: String = "",
    var updated: String = "",
    var section: String = "",
    var subsection: String = "",
    var adxKeywords: String = "",
    var column: String = "",
    var byline: String = "",
    var type: String = "",
    var title: String = "",
    var `abstract`: String = ""
) {
    @Relation(
        parentColumn = "resultId",
        entityColumn = "resultOwnerId"
    )
    var media: List<VMedia> = emptyList()
}

@Entity
data class VMedia(
    @PrimaryKey(autoGenerate = true)
    var mediaId: Long = 0L,
    @Relation(
        parentColumn = "mediaId",
        entityColumn = "mediaOwnerId"
    )
    var mediaMetadata: List<VMediaMetadata> = emptyList()
)

@Entity
data class VMediaMetadata(
    @PrimaryKey(autoGenerate = true)
    var mediaMetadataId: Long = 0L,
    var url: String = "",
    var mediaOwnerId: Long = 0L
)
