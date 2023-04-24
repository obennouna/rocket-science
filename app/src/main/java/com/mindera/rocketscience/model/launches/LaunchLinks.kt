package com.mindera.rocketscience.model.launches

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LaunchLinks(
    val article: String?,
    val flickr: Flickr,
    val patch: Patch,
    val presskit: String?,
    val reddit: Reddit,
    val webcast: String?,
    val wikipedia: String?,
    val youtube_id: String?
) : Parcelable