package com.mindera.rocketscience.model.launches

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Reddit(
    val campaign: String?,
    val launch: String?,
    val media: String?,
    val recovery: String?
) : Parcelable