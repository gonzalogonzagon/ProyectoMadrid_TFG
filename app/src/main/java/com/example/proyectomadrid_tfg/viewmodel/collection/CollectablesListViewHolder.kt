package com.example.proyectomadrid_tfg.viewmodel.collection

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomadrid_tfg.R
import com.example.proyectomadrid_tfg.databinding.ItemPoiListBinding
import com.example.proyectomadrid_tfg.model.poi_list.PointOfInterest

class CollectablesListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemPoiListBinding.bind(view)

    fun bind(pointOfInterest: PointOfInterest, clickListener: (PointOfInterest) -> Unit) {
        binding.ivPoiImage.setImageResource(pointOfInterest.image)
        binding.tvPoiTitle.setText(pointOfInterest.title)
        binding.tvPoiDescription.setText(pointOfInterest.subtitle)
        binding.categoryIndicator.setBackgroundColor(
            ContextCompat.getColor(itemView.context, R.color.black)
        )

        itemView.setOnClickListener { clickListener(pointOfInterest) }
    }
}