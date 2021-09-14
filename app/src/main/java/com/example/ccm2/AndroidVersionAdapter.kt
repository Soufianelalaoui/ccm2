package com.example.ccm2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ccm2.databinding.ItemCustomRecyclerBinding
import com.example.ccm2.model.ObjectDataSample

private val diffItemUtils = object : DiffUtil.ItemCallback<ObjectDataSample>() {


    override fun areItemsTheSame(oldItem: ObjectDataSample, newItem: ObjectDataSample): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: ObjectDataSample, newItem: ObjectDataSample): Boolean {
        return oldItem == newItem
    }
}


class AndroidVersionAdapter : ListAdapter<ObjectDataSample, AndroidVersionViewHolder>(diffItemUtils){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidVersionViewHolder {
        return AndroidVersionViewHolder(
            ItemCustomRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),parent, false)
        )
    }


    override fun onBindViewHolder(holder: AndroidVersionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class AndroidVersionViewHolder(
    private val binding: ItemCustomRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(objectDataSample: ObjectDataSample) {
        binding.itemRecyclerViewVersionName.text = objectDataSample.versionName
        binding.itemRecyclerViewVersionCode.text = "${objectDataSample.versionCode}"
    }
}
