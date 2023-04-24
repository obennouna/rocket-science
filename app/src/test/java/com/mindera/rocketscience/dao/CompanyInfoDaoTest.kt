package com.mindera.rocketscience.dao

import android.content.Context
import android.os.Build.VERSION_CODES.Q
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindera.rocketscience.TestUtil
import com.mindera.rocketscience.database.AppDatabase
import com.mindera.rocketscience.model.companyinfo.CompanyInfo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import java.io.IOException

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Q])
class CompanyInfoDaoTest {
    private lateinit var companyInfoDao: CompanyInfoDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
        companyInfoDao = db.companyInfoDao()
    }

    @Test
    @ExperimentalCoroutinesApi
    fun insertion_company_info_dao() {
        // Given
        val companyInfo: CompanyInfo = TestUtil.createCompanyInfo()

        // When
        runBlocking {
            companyInfoDao.insert(companyInfo)
        }

        var companyInfoGotten: CompanyInfo?
        runBlocking {
            companyInfoGotten = companyInfoDao.getAll()
        }

        // Then
        if (companyInfoGotten != null) {
            assertTrue(companyInfoGotten!!.name == companyInfo.name)
            assertTrue(companyInfoGotten!!.ceo == companyInfo.ceo)
            assertTrue(companyInfoGotten!!.founder == companyInfo.founder)
            assertTrue(companyInfoGotten!!.summary == companyInfo.summary)
            assertTrue(companyInfoGotten!!.founded == companyInfo.founded)
            assertTrue(companyInfoGotten!!.employees == companyInfo.employees)
        } else {
            fail("Cannot retrieve from DAO")
        }
    }

    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

}