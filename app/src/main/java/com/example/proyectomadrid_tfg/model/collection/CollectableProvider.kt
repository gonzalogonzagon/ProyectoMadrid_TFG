package com.example.proyectomadrid_tfg.model.collection

import com.example.proyectomadrid_tfg.R
import com.example.proyectomadrid_tfg.model.poi_list.PointOfInterest

object CollectableProvider {
    val collectableObjects: List<Collectable> = listOf(
        Collectable(
            title = R.string.collectable_map_title,
            subtitle = R.string.collectable_map_subtitle,
            image = R.drawable.img_mapa_villa_madrid,
            poi = PointOfInterest(
                title = R.string.collectable_map_title,
                subtitle = R.string.collectable_map_subtitle,
                image = R.drawable.img_mapa_villa_madrid,
                category = R.color.black,
                latitude = 40.4168,
                longitude = -3.7038,
            ),
        ),
        Collectable(
            title = R.string.collectable_postcard_title,
            subtitle = R.string.collectable_postcard_subtitle,
            image = R.drawable.img_postales,
            poiList = listOf(
                PointOfInterest(
                    title = R.string.puerta_sol_title,
                    subtitle = R.string.puerta_sol_description,
                    image = R.drawable.ic_launcher_foreground,
                    category = R.color.black,
                    latitude = 40.4170,
                    longitude = -3.7035
                ),
                PointOfInterest(
                    title = R.string.palacio_real_title,
                    subtitle = R.string.palacio_real_description,
                    image = R.drawable.ic_launcher_foreground,
                    category = R.color.black,
                    latitude = 40.4240,
                    longitude = -3.7170
                ),
                PointOfInterest(
                    title = R.string.parque_retiro_title,
                    subtitle = R.string.parque_retiro_description,
                    image = R.drawable.ic_launcher_foreground,
                    category = R.color.black,
                    latitude = 40.4180,
                    longitude = -3.7040
                ),
            )
        ),
    )
}