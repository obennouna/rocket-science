package com.mindera.rocketscience.repository

import android.content.Context
import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindera.rocketscience.TestUtil
import com.mindera.rocketscience.dao.CompanyInfoDao
import com.mindera.rocketscience.dao.LaunchDao
import com.mindera.rocketscience.dao.RocketDao
import com.mindera.rocketscience.database.AppDatabase
import com.mindera.rocketscience.model.companyinfo.CompanyInfo
import com.mindera.rocketscience.model.launches.Launch
import com.mindera.rocketscience.model.rocket.Rocket
import com.mindera.rocketscience.utils.MethodUtils
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
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
class RepositoryTest {
    private lateinit var companyInfoDao: CompanyInfoDao
    private lateinit var launchDao: LaunchDao
    private lateinit var rocketDao: RocketDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = AppDatabase.getInstance(context)
        companyInfoDao = db.companyInfoDao()
        launchDao = db.launchDao()
        rocketDao = db.rocketDao()

    }

    @Test
    @ExperimentalCoroutinesApi
    fun when_no_internet_fetch_local_company_info() {
        // Given
        val companyInfo = TestUtil.createCompanyInfo()
        val repository = RocketScienceRepository()

        runBlocking {
            companyInfoDao.insert(companyInfo)
        }

        mockkObject(MethodUtils.Companion)
        every { MethodUtils.isOnline(any()) } returns false

        // When
        var companyInfoResult: CompanyInfo?
        runBlocking {
            companyInfoResult =
                repository.getCompanyInfo(ApplicationProvider.getApplicationContext())
        }

        // Then
        if (companyInfoResult != null) {
            Assert.assertTrue(companyInfoResult!!.name == companyInfo.name)
            Assert.assertTrue(companyInfoResult!!.ceo == companyInfo.ceo)
            Assert.assertTrue(companyInfoResult!!.founder == companyInfo.founder)
            Assert.assertTrue(companyInfoResult!!.summary == companyInfo.summary)
            Assert.assertTrue(companyInfoResult!!.founded == companyInfo.founded)
            Assert.assertTrue(companyInfoResult!!.employees == companyInfo.employees)
        } else {
            Assert.fail("Cannot retrieve from DAO")
        }
    }

    @Test
    @ExperimentalCoroutinesApi
    fun when_no_internet_fetch_local_launches() {
        // Given
        val launches = TestUtil.createLaunchesInfo()
        val repository = RocketScienceRepository()

        runBlocking {
            launchDao.insert(launches)
        }

        mockkObject(MethodUtils.Companion)
        every { MethodUtils.isOnline(any()) } returns false

        // When
        var launchesGotten: List<Launch>?
        runBlocking {
            launchesGotten = repository.getLaunches(ApplicationProvider.getApplicationContext())
        }

        // Then
        if (launchesGotten != null) {
            Assert.assertTrue(launchesGotten!! == launches)
        } else {
            Assert.fail("Cannot retrieve from DAO")
        }
    }

    @Test
    @ExperimentalCoroutinesApi
    fun when_no_internet_fetch_local_rockets() {
        // Given
        val rockets = TestUtil.createRocketsInfo()
        val repository = RocketScienceRepository()

        runBlocking {
            rocketDao.insert(rockets)
        }

        mockkObject(MethodUtils.Companion)
        every { MethodUtils.isOnline(any()) } returns false

        // When
        var rocketsGotten: List<Rocket>?
        runBlocking {
            rocketsGotten = repository.getRockets(ApplicationProvider.getApplicationContext())
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