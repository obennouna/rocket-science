package com.mindera.rocketscience.dao

import android.content.Context
import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindera.rocketscience.TestUtil
import com.mindera.rocketscience.database.AppDatabase
import com.mindera.rocketscience.model.launches.Launch
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
class LaunchesDaoTest {
    private lateinit var launchesDao: LaunchDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
        launchesDao = db.launchDao()
    }

    @Test
    @ExperimentalCoroutinesApi
    fun insertion_launches_dao() {
        // Given
        val launches: List<Launch> = TestUtil.createLaunchesInfo()

        // When
        runBlocking {
            launchesDao.insert(launches)
        }

        var launchesGotten: List<Launch>?
        runBlocking {
            launchesGotten = launchesDao.getAll()
        }

        // Then
        if (launchesGotten != null) {
            Assert.assertTrue(launchesGotten!! == launches)
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