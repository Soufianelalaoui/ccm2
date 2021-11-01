package com.example.ccm2.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ccm2.chuckNorris.dao.ChuckNorrisDao
import com.example.ccm2.chuckNorris.model.ChuckNorrisRoom
import com.example.ccm2.myfeature.dao.AndroidVersionDao
import com.example.ccm2.myfeature.model.LocalDataSourceSample
import com.example.ccm2.tp4.dao.Tp4Dao
import com.example.ccm2.tp4.model.Tp4Room

@Database(
    entities = [
        LocalDataSourceSample::class,
        ChuckNorrisRoom::class,
        Tp4Room::class
    ],
    version = 3,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {


    abstract fun mAndroidVersionDao(): AndroidVersionDao


    abstract fun chuckNorrisDao() : ChuckNorrisDao


    abstract fun tp4Dao() : Tp4Dao
}

