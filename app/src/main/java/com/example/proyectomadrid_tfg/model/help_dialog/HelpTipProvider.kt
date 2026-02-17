package com.example.proyectomadrid_tfg.model.help_dialog

import com.example.proyectomadrid_tfg.R

object HelpTipProvider {
    val helpTipLists: List<HelpTip> = listOf(
        HelpTip(
            title = R.string.tobogan_title,
            message = R.string.tobogan_description,
            imageRes = R.drawable.img_tuto_cabina
        ),

        HelpTip(
            title = R.string.clara_campoamor_title,
            message = R.string.clara_campoamor_description2,
            imageRes = R.drawable.img_tuto_palacio_real
        ),

        HelpTip(
            title = R.string.cabina_telefonica_title,
            message = R.string.tobogan_description,
            imageRes = R.drawable.img_cabina_telefonica
        ),

        HelpTip(
            title = R.string.real_cinema_title,
            message = R.string.tobogan_description,
            imageRes = R.drawable.img_sol
        )
    )
}