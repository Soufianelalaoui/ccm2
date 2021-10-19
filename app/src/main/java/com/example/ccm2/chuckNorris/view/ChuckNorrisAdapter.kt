package com.example.ccm2.chuckNorris.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ccm2.chuckNorris.model.ChuckNorrisUi
import com.example.ccm2.chuckNorris.viewModel.ChuckNorrisViewModel
import com.example.ccm2.databinding.ActivityChuckNorrisBinding
import com.example.ccm2.databinding.ItemChuckNorrisBinding

val diffUtils = object : DiffUtil.ItemCallback<ChuckNorrisUi>() {
    override fun areItemsTheSame(oldItem: ChuckNorrisUi, newItem: ChuckNorrisUi): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: ChuckNorrisUi, newItem: ChuckNorrisUi): Boolean {
        return oldItem == newItem
    }
}

class ChuckNorrisQuoteViewHolder(
    val binding: ItemChuckNorrisBinding
) : RecyclerView.ViewHolder(binding.root) {


    private lateinit var ui: ChuckNorrisUi


    fun bind(chuckNorrisUi: ChuckNorrisUi) {
        ui = chuckNorrisUi
        Glide.with(itemView.context)
            .load(chuckNorrisUi.iconUrl)
            .into(binding.itemChuckNorrisIcon)


        binding.itemChuckNorrisQuote.text = chuckNorrisUi.quote
    }
}

class ChuckNorrisAdapter : ListAdapter<ChuckNorrisUi, ChuckNorrisQuoteViewHolder>(diffUtils) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChuckNorrisQuoteViewHolder {
        return ChuckNorrisQuoteViewHolder(
            ItemChuckNorrisBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ChuckNorrisQuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

