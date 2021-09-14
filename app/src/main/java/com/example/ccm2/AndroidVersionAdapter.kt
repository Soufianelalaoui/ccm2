package com.example.ccm2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ccm2.databinding.ItemCustomRecyclerBinding
import com.example.ccm2.databinding.ItemCustomRecyclerHeaderBinding
import com.example.ccm2.model.MyObjectForRecyclerView
import com.example.ccm2.model.ObjectDataHeaderSample
import com.example.ccm2.model.ObjectDataSample

private val diffItemUtils = object : DiffUtil.ItemCallback<MyObjectForRecyclerView>() {


    override fun areItemsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }
}


class AndroidVersionAdapter : ListAdapter<MyObjectForRecyclerView, RecyclerView.ViewHolder>(diffItemUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            MyItemType.ROW.type -> {
                AndroidVersionViewHolder(
                    ItemCustomRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            MyItemType.HEADER.type -> {
                AndroidVersionHeaderViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw RuntimeException("Wrong view type received $viewType")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            MyItemType.ROW.type -> (holder as AndroidVersionViewHolder).bind(getItem(position) as ObjectDataSample)
            MyItemType.HEADER.type -> (holder as AndroidVersionHeaderViewHolder).bind(getItem(position) as ObjectDataHeaderSample)
            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }
    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ObjectDataSample -> MyItemType.ROW.type
            is ObjectDataHeaderSample -> MyItemType.HEADER.type
        }
    }
    class AndroidVersionHeaderViewHolder(
        private val binding: ItemCustomRecyclerHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(objectDataHeaderSample: ObjectDataHeaderSample) {
            binding.itemRecyclerViewHeader.text = objectDataHeaderSample.header
        }
    }

    enum class MyItemType(val type: Int) {
        ROW(0),
        HEADER(1)
    }

    class AndroidVersionViewHolder(
        private val binding: ItemCustomRecyclerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(objectDataSample: ObjectDataSample) {
            binding.itemRecyclerViewVersionName.text = objectDataSample.versionName
            binding.itemRecyclerViewVersionCode.text = "${objectDataSample.versionCode}"
        }
    }
}


