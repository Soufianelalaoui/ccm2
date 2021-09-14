package com.example.ccm2.model


sealed class MyObjectForRecyclerView(label : String)


data class ObjectDataHeaderSample(
    val header: String
) : MyObjectForRecyclerView(label = header)


data class ObjectDataSample(
    val versionName: String,
    val versionCode: Int,
) : MyObjectForRecyclerView(label = versionName)