package com.example.ccm2.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ccm2.myfeature.dao.AndroidVersionDao
import com.example.ccm2.myfeature.model.LocalDataSourceSample

@Database(
    entities = [
        LocalDataSourceSample::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mAndroidVersionDao() : AndroidVersionDao
}
