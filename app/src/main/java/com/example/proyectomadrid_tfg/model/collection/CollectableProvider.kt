package com.example.proyectomadrid_tfg.model.collection

import com.example.proyectomadrid_tfg.R
import com.example.proyectomadrid_tfg.model.poi_list.DetailPointOfInterest
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
                detailPointOfInterest = DetailPointOfInterest(
                    arSceneId = R.string.tobogan_scene,
                    detailedDescription = R.string.collectable_map_description_long,
                    detailedDescription2 = R.string.collectable_map_description2,
                    detailImages = R.drawable.img_mancelli,
                    assistTutorial = R.string.collectable_map_tutorial,
                    assistTutorialImage = R.drawable.img_tuto_cabina,
                    url = R.string.map_external_link
                )
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
                    image = R.drawable.img_sol,
                    category = R.color.collectable_postcard,
                    latitude = 40.416843,
                    longitude = -3.703875,
                    detailPointOfInterest = DetailPointOfInterest(
                        arSceneId = R.string.tobogan_scene,
                        assistTutorial = R.string.puerta_sol_tutorial,
                        assistTutorialImage = R.drawable.img_tuto_sol,
                        url = R.string.puerta_sol_external_link
                    )
                ),
                PointOfInterest(
                    title = R.string.palacio_real_title,
                    subtitle = R.string.palacio_real_subtitle,
                    image = R.drawable.img_palacio,
                    category = R.color.collectable_postcard,
                    latitude = 40.416557,
                    longitude = -3.714431,
                    detailPointOfInterest = DetailPointOfInterest(
                        arSceneId = R.string.tobogan_scene,
                        assistTutorial = R.string.palacio_real_tutorial,
                        assistTutorialImage = R.drawable.img_tuto_palacio_real,
                        url = R.string.palacio_real_external_link
                    )
                ),
                PointOfInterest(
                    title = R.string.plaza_mayor_title,
                    subtitle = R.string.plaza_mayor_subtitle,
                    image = R.drawable.img_plaza,
                    category = R.color.collectable_postcard,
                    latitude = 40.415750,
                    longitude = -3.707392,
                    detailPointOfInterest = DetailPointOfInterest(
                        arSceneId = R.string.tobogan_scene,
                        assistTutorial = R.string.plaza_mayor_tutorial,
                        assistTutorialImage = R.drawable.img_tuto_plaza,
                        url = R.string.plaza_mayor_external_link
                    )
                ),
                PointOfInterest(
                    title = R.string.puerta_alcala_title,
                    subtitle = R.string.puerta_alcala_subtitle,
                    image = R.drawable.img_alcala,
                    category = R.color.collectable_postcard,
                    latitude = 40.419727,
                    longitude = -3.688097,
                    detailPointOfInterest = DetailPointOfInterest(
                        arSceneId = R.string.tobogan_scene,
                        assistTutorial = R.string.puerta_alcala_tutorial,
                        assistTutorialImage = R.drawable.img_tuto_alcala,
                        url = R.string.puerta_alcala_external_link
                    )
                ),

            )
        ),
    )
}