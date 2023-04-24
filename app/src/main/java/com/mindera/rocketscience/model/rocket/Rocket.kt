package com.mindera.rocketscience.model.rocket

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rocket(
    @PrimaryKey
    val id: String,
    val name: String,
    val type: String,
    val wikipedia: String
)