package com.example.proyectomadrid_tfg.model.help_dialog

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class HelpTip(
    @StringRes val title: Int,
    @StringRes val message: Int,
    @DrawableRes val imageRes: Int
)