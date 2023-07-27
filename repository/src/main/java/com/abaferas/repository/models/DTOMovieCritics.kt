package com.abaferas.repository.models


import com.google.gson.annotations.SerializedName

data class DTOMovieCritics(
    @SerializedName("status") val status: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("num_results") val numResults: Int,
    @SerializedName("results") val results: List<Result>
) {
    data class Result(
        @SerializedName("display_name") val displayName: String,
        @SerializedName("sort_name") val sortName: String,
        @SerializedName("status") val status: String,
        @SerializedName("bio") val bio: String,
        @SerializedName("seo_name") val seoName: String,
        @SerializedName("multimedia") val multimedia: Multimedia
    ) {
        data class Multimedia(
            @SerializedName("resource") val resource: Resource
        ) {
            data class Resource(
                @SerializedName("type") val type: String,
                @SerializedName("src") val src: String,
                @SerializedName("height") val height: Int,
                @SerializedName("width") val width: Int,
                @SerializedName("credit") val credit: String
            )
        }
    }
}