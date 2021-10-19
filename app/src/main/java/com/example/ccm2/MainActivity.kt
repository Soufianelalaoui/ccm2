package com.example.ccm2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ccm2.tp4.view.Tp4Activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickOpenRecyclerView(view: View) {
        val intent = Intent(this, Tp4Activity::class.java)
        startActivity(intent)
    }
}
