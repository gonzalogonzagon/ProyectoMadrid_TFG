package com.example.proyectomadrid_tfg.model.poi_list

import com.example.proyectomadrid_tfg.R

object PointOfInterestProvider {
    val pointOfInterestList: List<PointOfInterest> = listOf(
        PointOfInterest(
            title = R.string.tobogan_title,
            subtitle = R.string.tobogan_description,
            image = R.drawable.img_calle_alcala,
            category = R.color.poi_color_activity,
            latitude = 40.419199,
            longitude = -3.692473,
            detailPointOfInterest = DetailPointOfInterest(
                arSceneId = R.string.tobogan_scene,
                detailedDescription = R.string.tobogan_description,
                detailedDescription2 = R.string.tobogan_description,
                detailImages = R.drawable.img_calle_alcala,
                assistTutorial = R.string.lore_ipsum,
                assistTutorialImage = R.drawable.img_calle_alcala,
                wikiUrl = R.string.tobogan_external_link
            )
        ),

        PointOfInterest(
            title = R.string.clara_campoamor_title,
            subtitle = R.string.clara_campoamor_subtitle,
            image = R.drawable.img_monumento_clara_campoamor,
            category = R.color.poi_color_person,
            latitude = 40.427071,
            longitude = -3.710488,
        ),

        PointOfInterest(
            title = R.string.real_cinema_title,
            subtitle = R.string.real_cinema_subtitle,
            image = R.drawable.img_real_cinema,
            category = R.color.poi_color_culture,
            latitude = 40.418366,
            longitude = -3.709133,
        ),

        PointOfInterest(
            title = R.string.cabina_telefonica_title,
            subtitle = R.string.cabina_telefonica_subtitle,
            image = R.drawable.img_cabinas_telefonicas,
            category = R.color.poi_color_technology,
            latitude = 40.417959,
            longitude = -3.680223,
        ),

    )
}