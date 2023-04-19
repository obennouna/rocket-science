package com.mindera.rocketscience.database

import android.content.Context
import androidx.room.*
import com.mindera.rocketscience.dao.CompanyInfoDao
import com.mindera.rocketscience.dao.LaunchDao
import com.mindera.rocketscience.model.companyinfo.CompanyInfo
import com.mindera.rocketscience.model.launches.Launch
import com.mindera.rocketscience.utils.SingletonHolder
import com.mindera.rocketscience.utils.TypeConverterRoom

@Database(entities = [CompanyInfo::class, Launch::class], version = 1, exportSchema = true)
@TypeConverters(TypeConverterRoom::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun companyInfoDao(): CompanyInfoDao
    abstract fun launchDao(): LaunchDao

    companion object : SingletonHolder<AppDatabase, Context>({
        Room.databaseBuilder(it.applicationContext,
            AppDatabase::class.java, "rocketscience.db")
            .build()
    })
}