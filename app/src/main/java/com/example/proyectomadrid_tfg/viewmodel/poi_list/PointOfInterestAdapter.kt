package com.example.proyectomadrid_tfg.viewmodel.poi_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomadrid_tfg.R
import com.example.proyectomadrid_tfg.model.poi_list.PointOfInterest

class PointOfInterestAdapter(
    private val pointOfInterestList: List<PointOfInterest>,
    private val clickListener: (PointOfInterest) -> Unit
) : RecyclerView.Adapter<PointOfInterestViewHolder>() {

    override fun getItemCount(): Int = pointOfInterestList.size

    override fun onBindViewHolder(holder: PointOfInterestViewHolder, position: Int) {
        holder.bind(pointOfInterestList[position], clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointOfInterestViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PointOfInterestViewHolder(
            layoutInflater.inflate(
                R.layout.item_poi_list,
                parent,
                false
            )
        )
    }
}