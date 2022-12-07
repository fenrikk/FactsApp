package com.test.factsapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.factsapp.data.model.FactData
import com.test.factsapp.databinding.FactItemBinding
import com.test.factsapp.other.RENDER_DISTANCE

class FactAdapter(
    private val onEndReached: () -> Unit
): ListAdapter<FactData, FactAdapter.FactViewHolder>(FactDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        return FactViewHolder(
            FactItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        if (itemCount - position == RENDER_DISTANCE) {
            onEndReached()
        }
        holder.binding.fact.text = getItem(position).fact
    }

    class FactViewHolder(val binding: FactItemBinding) : RecyclerView.ViewHolder(binding.root)
}

class FactDiffCallBack : DiffUtil.ItemCallback<FactData>(){
    override fun areItemsTheSame(oldItem: FactData, newItem: FactData): Boolean {
        return oldItem.fact == newItem.fact
    }

    override fun areContentsTheSame(oldItem: FactData, newItem: FactData): Boolean {
        return oldItem == newItem
    }

}