package com.mindera.rocketscience.dao

import android.content.Context
import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindera.rocketscience.TestUtil
import com.mindera.rocketscience.database.AppDatabase
import com.mindera.rocketscience.model.rocket.Rocket
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import java.io.IOException

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.Q])
class RocketsDaoTest {
    private lateinit var rocketDao: RocketDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
        rocketDao = db.rocketDao()
    }

    @Test
    @ExperimentalCoroutinesApi
    fun insertion_rockets_dao() {
        // Given
        val rockets: List<Rocket> = TestUtil.createRocketsInfo()

        // When
        runBlocking {
            rocketDao.insert(rockets)
        }

        var rocketsGotten: List<Rocket>?
        runBlocking {
            rocketsGotten = rocketDao.getAll()
        }

        // Then
        if (rocketsGotten != null) {
            Assert.assertTrue(rocketsGotten!! == rockets)
        } else {
            Assert.fail("Cannot retrieve from DAO")
        }
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
}