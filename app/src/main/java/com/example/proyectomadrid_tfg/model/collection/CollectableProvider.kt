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
                latitude = 40.4100,
                longitude = -3.7000,
            ),
        ),
        Collectable(
            title = R.string.collectable_postcard_title,
            subtitle = R.string.collectable_postcard_subtitle,
            image = R.drawable.img_postales,
            poiList = listOf(
                PointOfInterest(
                    title = R.string.puerta_sol_title,
                    subtitle = R.string.puerta_sol_subtitle,
                    image = R.drawable.ic_launcher_foreground,
                    category = R.color.collectable_postcard,
                    latitude = 40.416843,
                    longitude = -3.703875
                ),
                PointOfInterest(
                    title = R.string.palacio_real_title,
                    subtitle = R.string.palacio_real_subtitle,
                    image = R.drawable.ic_launcher_foreground,
                    category = R.color.collectable_postcard,
                    latitude = 40.416557,
                    longitude = -3.714431
                ),
                PointOfInterest(
                    title = R.string.plaza_mayor_title,
                    subtitle = R.string.plaza_mayor_subtitle,
                    image = R.drawable.ic_launcher_foreground,
                    category = R.color.collectable_postcard,
                    latitude = 40.415750,
                    longitude = -3.707392
                ),
                PointOfInterest(
                    title = R.string.puerta_alcala_title,
                    subtitle = R.string.puerta_alcala_subtitle,
                    image = R.drawable.ic_launcher_foreground,
                    category = R.color.collectable_postcard,
                    latitude = 40.419727,
                    longitude = -3.688097
                ),
            )
        ),
    )
}