package com.example.ccm2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ccm2.model.ObjectDataSample

@Dao
interface AndroidVersionDao {

    @Query("SELECT * FROM android_version_object_table ORDER BY name ASC")
    fun selectAll(): LiveData<List<ObjectDataSample>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: ObjectDataSample)

    @Query("DELETE FROM android_version_object_table")
    fun deleteAll()
}