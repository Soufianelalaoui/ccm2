package com.example.ccm2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ccm2.databinding.ActivityRecyclerViewBinding
import com.example.ccm2.model.MyObjectForRecyclerView
import com.example.ccm2.model.ObjectDataHeaderSample
import com.example.ccm2.model.ObjectDataSample

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var mAdapter: AndroidVersionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Create the instance of adapter
        mAdapter = AndroidVersionAdapter()


        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        // We set the adapter to recycler view
        binding.recyclerView.adapter = mAdapter


        // Generate data and give it to adapter
        mAdapter.submitList(generateFakeData())
    }

    private fun generateFakeData(): MutableList<MyObjectForRecyclerView> {
        val result = mutableListOf<MyObjectForRecyclerView>()
        // Create data raw
        mutableListOf(
            ObjectDataSample("Android Lollipop", 5),
            ObjectDataSample("Android Marshmallow", 6),
            ObjectDataSample("Android Nougat", 7),
            ObjectDataSample("Android Oreo", 8),
            ObjectDataSample("Android Pie", 9),
            ObjectDataSample("Android Q", 10),
            ObjectDataSample("Android R", 11),
            ObjectDataSample("Android S", 12)
        ).groupBy {
            // Split in 2 list, modulo and not
            it.versionCode % 2 == 0
        }.forEach { (isModulo, items) ->
            // For each mean for each list split
            // Here we have a map (key = isModulo) and each key have a list of it's items
            result.add(ObjectDataHeaderSample("Is modulo : $isModulo"))
            result.addAll(items)
        }
        return result
    }

}
