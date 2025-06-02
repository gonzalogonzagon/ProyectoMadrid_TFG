package com.example.proyectomadrid_tfg.model.collection

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.proyectomadrid_tfg.model.poi_list.PointOfInterest

data class Collectable(
    @StringRes val title: Int,
    @StringRes val subtitle: Int? = null,
    @DrawableRes val image: Int,
    val poi: PointOfInterest? = null,
    val poiList: List<PointOfInterest>? = null
)
