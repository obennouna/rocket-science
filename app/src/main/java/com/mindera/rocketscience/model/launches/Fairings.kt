package com.mindera.rocketscience.model.launches

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fairings(
    val recovered: Boolean?,
    val recovery_attempt: Boolean?,
    val reused: Boolean?,
    val ships: List<String>
) : Parcelable