package com.abaferas.repository.models.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromKWordList(value: String): List<KWord> {
        val listType = object : TypeToken<List<KWord>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toKWordList(list: List<KWord>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromKMultimediaList(value: String): List<KMultimedia> {
        val listType = object : TypeToken<List<KMultimedia>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toKMultimediaList(list: List<KMultimedia>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromVMediaMetadataList(value: String): List<VMediaMetadata> {
        val listType = object : TypeToken<List<VMediaMetadata>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toVMediaMetadataList(list: List<VMediaMetadata>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromSKeywordList(value: String): List<StoryEntity.SKeyword> {
        val listType = object : TypeToken<List<StoryEntity.SKeyword>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toSKeywordList(list: List<StoryEntity.SKeyword>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromSMultiMediaList(value: String): List<StoryEntity.SMultimedia> {
        val listType = object : TypeToken<List<StoryEntity.SMultimedia>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toSMultiMediaList(list: List<StoryEntity.SMultimedia>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromIIsbnList(value: String): List<IIsbn> {
        val listType = object : TypeToken<List<IIsbn>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toIIsbnList(list: List<IIsbn>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromIBookDetailList(value: String): List<IBookDetail> {
        val listType = object : TypeToken<List<IBookDetail>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toIBookDetailList(list: List<IBookDetail>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromBBuyLinkList(value: String): List<ArticleListEntity.BResults.BLists.BBook.BBuyLink> {
        val listType =
            object : TypeToken<List<ArticleListEntity.BResults.BLists.BBook.BBuyLink>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toBBuyLinkList(list: List<ArticleListEntity.BResults.BLists.BBook.BBuyLink>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

}