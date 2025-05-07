package com.example.proyectomadrid_tfg.model.poi_list

import com.example.proyectomadrid_tfg.R

object PointOfInterestProvider {
    val pointOfInterestList: List<PointOfInterest> = listOf(
        PointOfInterest(
            title = R.string.tobogan_title,
            description = R.string.tobogan_description,
            category = R.color.dark_gray,
            image = R.drawable.img_calle_alcala,
            latitude = 40.419071,
            longitude = -3.692411,
        ),

        PointOfInterest(
            title = R.string.clara_campoamor_title,
            description = R.string.plaza_mayor_description,
            category = R.color.light_gray,
            image = R.drawable.img_monumento_clara_campoamor,
            latitude = 40.415861,
            longitude = -3.708398,
        ),

        PointOfInterest(
            title = R.string.real_cinema_title,
            description = R.string.templo_debod_description,
            category = R.color.gray,
            image = R.drawable.img_real_cinema,
            latitude = 40.423700,
            longitude = -3.718400,
        ),

        PointOfInterest(
            title = R.string.cabina_telefonica_title,
            description = R.string.parque_retiro_description,
            category = R.color.gray,
            image = R.drawable.ic_launcher_foreground,
            latitude = 40.415363,
            longitude = -3.707398,
        ),


        PointOfInterest(
            title = R.string.puerta_sol_title,
            description = R.string.puerta_sol_description,
            category = R.color.error,
            image = R.drawable.ic_launcher_foreground,
            latitude = 40.416775,
            longitude = -3.703790,
        ),

        PointOfInterest(
            title = R.string.palacio_real_title,
            description = R.string.palacio_real_description,
            category = R.color.light_gray,
            image = R.drawable.ic_launcher_foreground,
            latitude = 40.417940,
            longitude = -3.711769,
        ),

        PointOfInterest(
            title = R.string.gran_via_title,
            description = R.string.gran_via_description,
            category = R.color.black,
            image = R.drawable.ic_launcher_foreground,
            latitude = 40.420000,
            longitude = -3.703790,
        ),
    )
}