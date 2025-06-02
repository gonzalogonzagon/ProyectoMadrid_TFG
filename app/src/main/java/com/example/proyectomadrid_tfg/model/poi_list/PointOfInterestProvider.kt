package com.example.proyectomadrid_tfg.model.poi_list

import com.example.proyectomadrid_tfg.R

object PointOfInterestProvider {
    val pointOfInterestList: List<PointOfInterest> = listOf(
        PointOfInterest(
            title = R.string.tobogan_title,
            subtitle = R.string.tobogan_description,
            image = R.drawable.img_calle_alcala,
            category = R.color.dark_gray,
            latitude = 40.419071,
            longitude = -3.692411,
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
            subtitle = R.string.plaza_mayor_description,
            image = R.drawable.img_monumento_clara_campoamor,
            category = R.color.light_gray,
            latitude = 40.415861,
            longitude = -3.708398,
        ),

        PointOfInterest(
            title = R.string.real_cinema_title,
            subtitle = R.string.templo_debod_description,
            image = R.drawable.img_real_cinema,
            category = R.color.gray,
            latitude = 40.423700,
            longitude = -3.718400,
        ),

        PointOfInterest(
            title = R.string.cabina_telefonica_title,
            subtitle = R.string.parque_retiro_description,
            image = R.drawable.img_cabinas_telefonicas,
            category = R.color.gray,
            latitude = 40.415363,
            longitude = -3.707398,
        ),


        PointOfInterest(
            title = R.string.puerta_sol_title,
            subtitle = R.string.puerta_sol_description,
            category = R.color.error,
            image = R.drawable.ic_launcher_foreground,
            latitude = 40.416775,
            longitude = -3.703790,
        ),

        PointOfInterest(
            title = R.string.palacio_real_title,
            subtitle = R.string.palacio_real_description,
            category = R.color.light_gray,
            image = R.drawable.ic_launcher_foreground,
            latitude = 40.417940,
            longitude = -3.711769,
        ),

        PointOfInterest(
            title = R.string.gran_via_title,
            subtitle = R.string.gran_via_description,
            category = R.color.black,
            image = R.drawable.ic_launcher_foreground,
            latitude = 40.420000,
            longitude = -3.703790,
        ),
    )
}