package com.mindera.rocketscience.model.launches

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Patch(
    val large: String?,
    val small: String?
) : Parcelable