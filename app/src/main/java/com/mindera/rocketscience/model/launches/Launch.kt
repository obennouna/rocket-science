package com.mindera.rocketscience.model.launches

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Launch(
    val auto_update: Boolean,
    val capsules: List<String>,
    val cores: List<Core>,
    val crew: List<String>,
    val date_local: String,
    val date_precision: String,
    val date_unix: Int,
    val date_utc: String,
    val details: String?,
    val failures: List<Failure>,
    val fairings: Fairings?,
    val flight_number: Int,
    @PrimaryKey
    val id: String,
    val launch_library_id: String?,
    val launchpad: String,
    val links: LaunchLinks,
    val name: String,
    val net: Boolean,
    val payloads: List<String>,
    val rocket: String,
    val ships: List<String>,
    val static_fire_date_unix: Int?,
    val static_fire_date_utc: String?,
    val success: Boolean?,
    val tbd: Boolean,
    val upcoming: Boolean,
    val window: Int?
) : Parcelable