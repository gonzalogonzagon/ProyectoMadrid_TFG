package com.example.proyectomadrid_tfg.model.poi_list

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PointOfInterest(
    @StringRes val title: Int,
    @StringRes val subtitle: Int,
    @DrawableRes val image: Int,
    @ColorRes val category: Int,
    val latitude: Double,
    val longitude: Double,
    val detailPointOfInterest: DetailPointOfInterest? = null,
)
