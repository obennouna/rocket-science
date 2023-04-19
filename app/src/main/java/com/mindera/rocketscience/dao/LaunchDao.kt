package com.mindera.rocketscience.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mindera.rocketscience.model.launches.Launch

@Dao
interface LaunchDao {
    @Query("SELECT * FROM Launch")
    suspend fun getAll(): List<Launch>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(launches: List<Launch>)
}