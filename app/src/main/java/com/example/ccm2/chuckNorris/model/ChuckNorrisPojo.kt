package com.example.ccm2.chuckNorris.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** Object use for room */
@Entity(tableName = "chuck_norris_quote")
data class ChuckNorrisRoom(
    @ColumnInfo(name = "quote_text")
    val quote: String,


    @ColumnInfo(name = "quote_icon_url")
    val iconUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}


data class ChuckNorrisUi(
    val quote: String,
    val iconUrl: String
)
