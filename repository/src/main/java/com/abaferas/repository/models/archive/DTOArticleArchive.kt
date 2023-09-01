package com.abaferas.repository.models.archive


import com.google.gson.annotations.SerializedName

data class DTOArticleArchive(
    @SerializedName("copyright") val copyright: String,
    @SerializedName("response") val response: Response
) {
    data class Response(
        @SerializedName("docs") val docs: List<Doc>,
        @SerializedName("meta") val meta: Meta
    ) {
        data class Doc(
            @SerializedName("abstract") val `abstract`: String,
            @SerializedName("web_url") val webUrl: String,
            @SerializedName("snippet") val snippet: String,
            @SerializedName("lead_paragraph") val leadParagraph: String,
            @SerializedName("source") val source: String,
            @SerializedName("multimedia") val multimedia: List<Multimedia>,
            @SerializedName("headline") val headline: Headline,
            @SerializedName("keywords") val keywords: List<Keyword>,
            @SerializedName("pub_date") val pubDate: String,
            @SerializedName("document_type") val documentType: String,
            @SerializedName("news_desk") val newsDesk: String,
            @SerializedName("section_name") val sectionName: String,
            @SerializedName("byline") val byline: Byline,
            @SerializedName("type_of_material") val typeOfMaterial: String,
            @SerializedName("_id") val id: String,
            @SerializedName("word_count") val wordCount: Int,
            @SerializedName("uri") val uri: String
        ) {
            data class Multimedia(
                @SerializedName("rank") val rank: Int,
                @SerializedName("subtype") val subtype: String,
                @SerializedName("caption") val caption: Any,
                @SerializedName("credit") val credit: Any,
                @SerializedName("type") val type: String,
                @SerializedName("url") val url: String,
                @SerializedName("height") val height: Int,
                @SerializedName("width") val width: Int,
                @SerializedName("subType") val subType: String,
                @SerializedName("crop_name") val cropName: String,
                @SerializedName("legacy") val legacy: Legacy
            ) {
                data class Legacy(
                    @SerializedName("xlarge") val xlarge: String,
                    @SerializedName("xlargewidth") val xlargewidth: Int,
                    @SerializedName("xlargeheight") val xlargeheight: Int,
                    @SerializedName("thumbnail") val thumbnail: String,
                    @SerializedName("thumbnailwidth") val thumbnailwidth: Int,
                    @SerializedName("thumbnailheight") val thumbnailheight: Int
                )
            }
            data class Headline(
                @SerializedName("main") val main: String,
                @SerializedName("kicker") val kicker: String,
                @SerializedName("content_kicker") val contentKicker: String,
                @SerializedName("print_headline") val printHeadline: String,
                @SerializedName("name") val name: String,
                @SerializedName("seo") val seo: String,
                @SerializedName("sub") val sub: String
            )
            data class Keyword(
                @SerializedName("name") val name: String,
                @SerializedName("value") val value: String,
                @SerializedName("rank") val rank: Int,
                @SerializedName("major") val major: String
            )
            data class Byline(
                @SerializedName("original") val original: String,
                @SerializedName("person") val person: List<Person>,
                @SerializedName("organization") val organization: String
            ) {
                data class Person(
                    @SerializedName("firstname") val firstname: String,
                    @SerializedName("middlename") val middlename: Any,
                    @SerializedName("lastname") val lastname: String,
                    @SerializedName("qualifier") val qualifier: String,
                    @SerializedName("title") val title: String,
                    @SerializedName("role") val role: String,
                    @SerializedName("organization") val organization: String,
                    @SerializedName("rank") val rank: Int
                )
            }
        }
        data class Meta(
            @SerializedName("hits") val hits: Int
        )
    }
}