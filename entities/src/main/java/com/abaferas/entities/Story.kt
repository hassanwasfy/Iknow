package com.abaferas.entities

data class Story(
    val section: String = "",
    val title: String = "",
    val `abstract`: String = "",
    val url: String = "",
    val byline: String = "",
    val updatedDate: String = "",
    val keyWords: List<String> = emptyList(),
    val multimedia: List<Multimedia> = emptyList(),
    val shortUrl: String = ""
) {
    data class Multimedia(
        val url: String = "",
    )
}
