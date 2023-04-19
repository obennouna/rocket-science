package com.mindera.rocketscience.model.launches

data class Failure(
    val altitude: Int?,
    val reason: String,
    val time: Int
)