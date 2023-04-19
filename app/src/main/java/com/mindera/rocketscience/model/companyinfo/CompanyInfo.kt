package com.mindera.rocketscience.model.companyinfo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CompanyInfo(
    @PrimaryKey
    val name: String,
    val founder: String,
    val founded: Int,
    val employees: Int,
    val vehicles: Int,
    val launch_sites: Int,
    val test_sites: Int,
    val ceo: String,
    val cto: String,
    val coo: String,
    val cto_propulsion: String,
    val valuation: Long,
    val headquarters: Headquarters,
    val summary: String
)