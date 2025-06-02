package com.example.proyectomadrid_tfg.viewmodel.collection

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomadrid_tfg.R
import com.example.proyectomadrid_tfg.databinding.ItemPoiListBinding
import com.example.proyectomadrid_tfg.model.collection.Collectable

class CollectablesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPoiListBinding.bind(view)

    fun bind(collectable: Collectable, clickListener: (Collectable) -> Unit) {
        binding.ivPoiImage.setImageResource(collectable.image)
        binding.tvPoiTitle.setText(collectable.title)
        collectable.subtitle?.let {
            binding.tvPoiDescription.setText(it)
        } ?: run {
            binding.tvPoiDescription.text = ""
        }
        binding.categoryIndicator.setBackgroundColor(
            ContextCompat.getColor(itemView.context, R.color.black)
        )

        itemView.setOnClickListener { clickListener(collectable) }
    }
}