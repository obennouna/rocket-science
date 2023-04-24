package com.mindera.rocketscience.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mindera.rocketscience.model.rocket.Rocket

@Dao
interface RocketDao {
    @Query("SELECT * FROM Rocket")
    suspend fun getAll(): List<Rocket>?

    @Query("SELECT * FROM Rocket WHERE id=:id")
    suspend fun getRocketById(id: String): Rocket?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rockets: List<Rocket>)
}