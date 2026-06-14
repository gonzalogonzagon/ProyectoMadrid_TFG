package com.example.proyectomadrid_tfg.model.help_dialog

import com.example.proyectomadrid_tfg.R

object HelpTipProvider {
    val helpTipLists: List<HelpTip> = listOf(
        HelpTip(
            title = R.string.tuto_title1,
            message = R.string.tuto_desc1,
            imageRes = R.drawable.img_tuto_madrid_recuerdo_aumentado
        ),

        HelpTip(
            title = R.string.tuto_title2,
            message = R.string.tuto_desc2,
            imageRes = R.drawable.img_tuto_poi
        ),

        HelpTip(
            title = R.string.tuto_title3,
            message = R.string.tuto_desc3,
            imageRes = R.drawable.img_tuto_ar_content
        ),

        HelpTip(
            title = R.string.tuto_title4,
            message = R.string.tuto_desc4,
            imageRes = R.drawable.img_tuto_postcards
        ),

        HelpTip(
            title = R.string.tuto_title5,
            message = R.string.tuto_desc5,
            imageRes = R.drawable.img_tuto_map
        )
    )
}