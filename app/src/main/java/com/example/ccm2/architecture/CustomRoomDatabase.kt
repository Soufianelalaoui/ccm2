package com.example.ccm2.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ccm2.dao.AndroidVersionDao
import com.example.ccm2.model.ObjectDataSample

@Database(
    entities = [
        ObjectDataSample::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mAndroidVersionDao() : AndroidVersionDao
}
