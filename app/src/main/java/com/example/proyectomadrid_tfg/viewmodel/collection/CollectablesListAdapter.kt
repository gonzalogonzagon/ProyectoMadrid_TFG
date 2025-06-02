package com.example.proyectomadrid_tfg.viewmodel.collection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomadrid_tfg.R
import com.example.proyectomadrid_tfg.model.poi_list.PointOfInterest

class CollectablesListAdapter(
    private val poiList: List<PointOfInterest>,
    private val clickListener: (PointOfInterest) -> Unit
) : RecyclerView.Adapter<CollectablesListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectablesListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_poi_list, parent, false)
        return CollectablesListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectablesListViewHolder, position: Int) {
        holder.bind(poiList[position], clickListener)
    }

    override fun getItemCount(): Int = poiList.size
}