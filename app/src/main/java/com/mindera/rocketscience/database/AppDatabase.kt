package com.mindera.rocketscience.database

import android.content.Context
import androidx.room.*
import com.mindera.rocketscience.dao.CompanyInfoDao
import com.mindera.rocketscience.dao.LaunchDao
import com.mindera.rocketscience.dao.RocketDao
import com.mindera.rocketscience.model.companyinfo.CompanyInfo
import com.mindera.rocketscience.model.launches.Launch
import com.mindera.rocketscience.model.rocket.Rocket
import com.mindera.rocketscience.utils.SingletonHolder
import com.mindera.rocketscience.utils.TypeConverterRoom

@Database(entities = [CompanyInfo::class, Launch::class, Rocket::class], version = 1, exportSchema = true)
@TypeConverters(TypeConverterRoom::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun companyInfoDao(): CompanyInfoDao
    abstract fun launchDao(): LaunchDao
    abstract fun rocketDao(): RocketDao

    companion object : SingletonHolder<AppDatabase, Context>({
        Room.databaseBuilder(it.applicationContext,
            AppDatabase::class.java, "rocketscience.db")
            .build()
    })
}