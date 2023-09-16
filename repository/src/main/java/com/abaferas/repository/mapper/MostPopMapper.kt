package com.abaferas.repository.mapper

import com.abaferas.entities.MostPopularArticle
import com.abaferas.repository.models.entity.MostPopularArticleEntity
import com.abaferas.repository.models.entity.VMedia
import com.abaferas.repository.models.entity.VMediaMetadata
import com.abaferas.repository.models.entity.VResult

fun MostPopularArticle.toMostPopularArticleEntity(): MostPopularArticleEntity {
    val mostPopularArticleEntity = MostPopularArticleEntity()
    mostPopularArticleEntity.results = this.results.map { result ->
        val vResult = VResult(
            url = result.url,
            idR = result.idR,
            source = result.source,
            updated = result.updated,
            section = result.section,
            subsection = result.subsection,
            adxKeywords = result.adxKeywords,
            column = result.column,
            byline = result.byline,
            type = result.type,
            title = result.title,
            `abstract` = result.abstract
        )

        vResult.media = result.media.map { media ->
            VMedia().apply {
                mediaMetadata = media.mediaMetadata.map { metadata ->
                    VMediaMetadata(url = metadata.url)
                }
            }
        }

        vResult
    }
    return mostPopularArticleEntity
}


fun MostPopularArticleEntity.toMostPopularArticle(): MostPopularArticle {
    val mostPopularArticle = MostPopularArticle(
        results = this.results.map { vResult ->
            MostPopularArticle.Result(
                url = vResult.url,
                idR = vResult.idR,
                source = vResult.source,
                updated = vResult.updated,
                section = vResult.section,
                subsection = vResult.subsection,
                adxKeywords = vResult.adxKeywords,
                column = vResult.column,
                byline = vResult.byline,
                type = vResult.type,
                title = vResult.title,
                `abstract` = vResult.`abstract`,
                media = vResult.media.map { vMedia ->
                    MostPopularArticle.Result.Media(
                        mediaMetadata = vMedia.mediaMetadata.map { vMediaMetadata ->
                            MostPopularArticle.Result.Media.MediaMetadata(
                                url = vMediaMetadata.url
                            )
                        }
                    )
                }
            )
        }
    )
    return mostPopularArticle
}

