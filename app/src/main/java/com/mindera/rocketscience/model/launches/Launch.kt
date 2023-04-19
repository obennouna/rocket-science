package com.mindera.rocketscience.model.launches


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Launch(
    @Json(name = "auto_update")
    val autoUpdate: Boolean?,
    @Json(name = "capsules")
    val capsules: List<String>?,
    @Json(name = "cores")
    val cores: List<Core>?,
    @Json(name = "crew")
    val crew: List<String>?,
    @Json(name = "date_local")
    val dateLocal: String?,
    @Json(name = "date_precision")
    val datePrecision: String?,
    @Json(name = "date_unix")
    val dateUnix: Long?,
    @Json(name = "date_utc")
    val dateUtc: String?,
    @Json(name = "details")
    val details: String?,
    @Json(name = "failures")
    val failures: List<Failure>?,
    @Json(name = "fairings")
    val fairings: Fairings?,
    @Json(name = "flight_number")
    val flightNumber: Int?,
    @PrimaryKey
    @Json(name = "id")
    val id: String,
    @Json(name = "launch_library_id")
    val launchLibraryId: String?,
    @Json(name = "launchpad")
    val launchpad: String?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "net")
    val net: Boolean?,
    @Json(name = "payloads")
    val payloads: List<String>?,
    @Json(name = "rocket")
    val rocket: String?,
    @Json(name = "ships")
    val ships: List<String>?,
    @Json(name = "static_fire_date_unix")
    val staticFireDateUnix: Int?,
    @Json(name = "static_fire_date_utc")
    val staticFireDateUtc: String?,
    @Json(name = "success")
    val success: Boolean?,
    @Json(name = "tbd")
    val tbd: Boolean?,
    @Json(name = "upcoming")
    val upcoming: Boolean?,
    @Json(name = "window")
    val window: Int?
) {
    data class Core(
        @Json(name = "core")
        val core: String?,
        @Json(name = "flight")
        val flight: Int?,
        @Json(name = "gridfins")
        val gridfins: Boolean?,
        @Json(name = "landing_attempt")
        val landingAttempt: Boolean?,
        @Json(name = "landing_success")
        val landingSuccess: Boolean?,
        @Json(name = "landing_type")
        val landingType: String?,
        @Json(name = "landpad")
        val landpad: String?,
        @Json(name = "legs")
        val legs: Boolean?,
        @Json(name = "reused")
        val reused: Boolean?
    )

    data class Failure(
        @Json(name = "altitude")
        val altitude: Int?,
        @Json(name = "reason")
        val reason: String,
        @Json(name = "time")
        val time: Int?
    )

    data class Fairings(
        @Json(name = "recovered")
        val recovered: Boolean?,
        @Json(name = "recovery_attempt")
        val recoveryAttempt: Boolean?,
        @Json(name = "reused")
        val reused: Boolean?,
        @Json(name = "ships")
        val ships: List<String>
    )

    data class Links(
        @Json(name = "article")
        val article: String?,
        @Json(name = "flickr")
        val flickr: Flickr?,
        @Json(name = "patch")
        val patch: Patch?,
        @Json(name = "presskit")
        val presskit: String?,
        @Json(name = "reddit")
        val reddit: Reddit?,
        @Json(name = "webcast")
        val webcast: String?,
        @Json(name = "wikipedia")
        val wikipedia: String?,
        @Json(name = "youtube_id")
        val youtubeId: String?
    ) {
        data class Flickr(
            @Json(name = "original")
            val original: List<String>?,
            @Json(name = "small")
            val small: List<Any>?
        )

        data class Patch(
            @Json(name = "large")
            val large: String?,
            @Json(name = "small")
            val small: String?
        )

        data class Reddit(
            @Json(name = "campaign")
            val campaign: String?,
            @Json(name = "launch")
            val launch: String?,
            @Json(name = "media")
            val media: String?,
            @Json(name = "recovery")
            val recovery: String?
        )
    }
}