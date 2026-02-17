package com.example.proyectomadrid_tfg.viewmodel.help_dialog

import com.example.proyectomadrid_tfg.model.help_dialog.HelpTip

class HelpDialogAdapter(private val helpTipList: List<HelpTip>) {
    private var currentIndex = 0

    fun getCurrentPage(): HelpTip = helpTipList[currentIndex]
    fun isFirstPage(): Boolean = currentIndex == 0
    fun isLastPage(): Boolean = currentIndex == helpTipList.size - 1

    fun nextPage() = if (!isLastPage()) currentIndex++ else currentIndex
    fun prevPage() = if (!isFirstPage()) currentIndex-- else currentIndex
}