package com.example.proyectomadrid_tfg.viewmodel.poi_list

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomadrid_tfg.databinding.ItemPoiListBinding
import com.example.proyectomadrid_tfg.model.poi_list.PointOfInterest

class PointOfInterestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemPoiListBinding.bind(view)

    fun bind(pointOfInterest: PointOfInterest, clickListener: (PointOfInterest) -> Unit) {
        // Configurar la imagen
        binding.ivPoiImage.setImageResource(pointOfInterest.image)
        
        // Configurar el título
        binding.tvPoiTitle.setText(pointOfInterest.title)
        
        // Configurar la descripción
        binding.tvPoiDescription.setText(pointOfInterest.description)
        
        // Configurar el color de categoría
        binding.categoryIndicator.setBackgroundColor(
            ContextCompat.getColor(itemView.context, pointOfInterest.category)
        )
        
        // Configurar el click listener
        itemView.setOnClickListener { clickListener(pointOfInterest) }
    }
}