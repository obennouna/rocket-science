package com.mindera.rocketscience.dao

import androidx.room.*
import com.mindera.rocketscience.model.companyinfo.CompanyInfo

@Dao
interface CompanyInfoDao {
    @Query("SELECT * FROM CompanyInfo")
    suspend fun getAll(): CompanyInfo?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(companyInfo: CompanyInfo)
}
