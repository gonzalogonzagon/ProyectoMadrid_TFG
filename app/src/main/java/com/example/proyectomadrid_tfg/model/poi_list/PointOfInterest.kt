package com.example.proyectomadrid_tfg.model.poi_list

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PointOfInterest(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @ColorRes val category: Int,
    @DrawableRes val image: Int,
    val latitude: Double,
    val longitude: Double,
    @DrawableRes val mapIcon: Int? = null,
    @StringRes val detailedDescription: Int? = null, // Descripción detallada para la vista en detalle
    @DrawableRes val detailImages: List<Int> = emptyList(), // Imágenes adicionales para la vista detalle
    val arSceneId: String? = null, // Identificador de escena AR
    val wikiUrl: String? = null, // Enlace a Wikipedia
)
