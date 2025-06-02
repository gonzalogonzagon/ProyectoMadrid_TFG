package com.example.proyectomadrid_tfg.model.poi_list

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DetailPointOfInterest(
    val arSceneId: Int? = null, // Identificador de escena AR
    @StringRes val detailedDescription: Int? = null, // Descripción detallada para la vista en detalle
    @StringRes val detailedDescription2: Int? = null, // Segunda parte de la descripción detallada
    @DrawableRes val detailImages: Int? = null, // Imágenes adicionales para la vista detalle
    @StringRes val assistTutorial: Int? = null,
    @DrawableRes val assistTutorialImage: Int? = null,
    val wikiUrl: Int? = null, // Enlace a Wikipedia
)
