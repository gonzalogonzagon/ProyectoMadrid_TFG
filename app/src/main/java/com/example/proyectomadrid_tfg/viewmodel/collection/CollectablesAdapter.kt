package com.example.proyectomadrid_tfg.viewmodel.collection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomadrid_tfg.R
import com.example.proyectomadrid_tfg.model.collection.Collectable

class CollectablesAdapter(
    private val collectables: List<Collectable>,
    private val clicListener: (Collectable) -> Unit
): RecyclerView.Adapter<CollectablesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectablesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_poi_list, parent, false)
        return CollectablesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectablesViewHolder, position: Int) {
        holder.bind(collectables[position], clicListener)
    }

    override fun getItemCount(): Int = collectables.size
}