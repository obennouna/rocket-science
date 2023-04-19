package com.mindera.rocketscience.utils

import androidx.room.TypeConverter
import com.mindera.rocketscience.model.companyinfo.Headquarters
import com.mindera.rocketscience.model.companyinfo.Links
import com.mindera.rocketscience.model.launches.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class TypeConverterRoom {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromStringToHeadquarters(value: String): Headquarters? {
        return moshi.adapter(Headquarters::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromHeadquartersToString(value: Headquarters): String {
        return moshi.adapter(Headquarters::class.java).toJson(value)
    }

    @TypeConverter
    fun fromStringToLinks(value: String): Links? {
        return moshi.adapter(Links::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromLinksToString(value: Links): String {
        return moshi.adapter(Links::class.java).toJson(value)
    }

    @TypeConverter
    fun fromStringToFlickr(value: String): Flickr? {
        return moshi.adapter(Flickr::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromFlickrToString(value: Flickr): String {
        return moshi.adapter(Flickr::class.java).toJson(value)
    }

    @TypeConverter
    fun fromStringToReddit(value: String): Reddit? {
        return moshi.adapter(Reddit::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromRedditToString(value: Reddit): String {
        return moshi.adapter(Reddit::class.java).toJson(value)
    }

    @TypeConverter
    fun fromStringToPatch(value: String): Patch? {
        return moshi.adapter(Patch::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromPatchToString(value: Patch): String {
        return moshi.adapter(Patch::class.java).toJson(value)
    }

    @TypeConverter
    fun fromStringToLinksLaunch(value: String): LaunchLinks? {
        return moshi.adapter(LaunchLinks::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromLinksLaunchToString(value: LaunchLinks): String {
        return moshi.adapter(LaunchLinks::class.java).toJson(value)
    }

    @TypeConverter
    fun fromStringToCore(value: String): Core? {
        return moshi.adapter(Core::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromCoreToString(value: Core): String {
        return moshi.adapter(Core::class.java).toJson(value)
    }

    @TypeConverter
    fun fromStringToFailure(value: String): Failure? {
        return moshi.adapter(Failure::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromFailureToString(value: Failure): String {
        return moshi.adapter(Failure::class.java).toJson(value)
    }

    @TypeConverter
    fun fromStringToFairings(value: String): Fairings? {
        return moshi.adapter(Fairings::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromFairingsToString(value: Fairings?): String {
        return moshi.adapter(Fairings::class.java).toJson(value)
    }

    @TypeConverter
    fun fromListStringToString(value: List<String>): String {
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        return moshi.adapter<List<String>>(type).toJson(value)
    }

    @TypeConverter
    fun fromStringToListString(value: String): List<String>? {
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        return moshi.adapter<List<String>>(type).fromJson(value)
    }

    @TypeConverter
    fun fromListCoreToString(value: List<Core>): String {
        val type = Types.newParameterizedType(List::class.java, Core::class.java)
        return moshi.adapter<List<Core>>(type).toJson(value)
    }

    @TypeConverter
    fun fromStringToListCore(value: String): List<Core>? {
        val type = Types.newParameterizedType(List::class.java, Core::class.java)
        return moshi.adapter<List<Core>>(type).fromJson(value)
    }

    @TypeConverter
    fun fromListFailureToString(value: List<Failure>): String {
        val type = Types.newParameterizedType(List::class.java, Failure::class.java)
        return moshi.adapter<List<Failure>>(type).toJson(value)
    }

    @TypeConverter
    fun fromStringToListFailure(value: String): List<Failure>? {
        val type = Types.newParameterizedType(List::class.java, Failure::class.java)
        return moshi.adapter<List<Failure>>(type).fromJson(value)
    }
}