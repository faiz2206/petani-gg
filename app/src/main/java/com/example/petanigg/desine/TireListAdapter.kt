package com.example.petanigg.desine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.petanigg.R
import com.example.petanigg.table.TireTable


class TireListAdapter(
    private val onItemClickListener: (TireTable) -> Unit
) : ListAdapter<TireTable, TireListAdapter.TireViewHolder>(WORDS_COMPARATOR)  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TireViewHolder {
        return TireViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TireViewHolder, position: Int) {
        val tire = getItem(position)
        holder.bind(tire)
        holder.itemView.setOnClickListener {
            onItemClickListener(tire)
        }
    }

    class TireViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameItemView: TextView = itemView.findViewById(R.id.nameTextView)
        private val priceItemView: TextView = itemView.findViewById(R.id.addressTextView)

        fun bind(tire: TireTable?) {
            nameItemView.text =  tire?.name
            priceItemView.text = tire?.address
        }

        companion object {
            fun create(parent: ViewGroup): TireViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_tire, parent, false)
                return TireViewHolder(view)
            }
        }
    }

    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<TireTable>() {
            override fun areItemsTheSame(oldItem: TireTable, newItem: TireTable): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: TireTable, newItem: TireTable): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}