package com.example.proyectomadrid_tfg.model.poi_list

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DetailPointOfInterest(
    val arSceneId: Int? = null,
    @StringRes val detailedDescription: Int? = null,
    @StringRes val detailedDescription2: Int? = null,
    @DrawableRes val detailImages: Int? = null,
    @StringRes val assistTutorial: Int? = null,
    @DrawableRes val assistTutorialImage: Int? = null,
    @StringRes val ulrText: Int? = null,
    val url: Int? = null,
    val urlList: List<Int>? = null
)
