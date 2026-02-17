package com.example.proyectomadrid_tfg.viewmodel.help_dialog

import android.view.View
import com.example.proyectomadrid_tfg.databinding.DialogHelpBinding
import com.example.proyectomadrid_tfg.model.help_dialog.HelpTip

class HelpDialogViewHolder(view: View) {
    private val binding = DialogHelpBinding.bind(view)

    fun bind(page: HelpTip, isFirst: Boolean, isLast: Boolean) {
        binding.tvHelpTitle.setText(page.title)
        binding.tvHelpMessage.setText(page.message)
        binding.ivHelpImage.setImageResource(page.imageRes)
        binding.btnPrevious.isEnabled = !isFirst
        binding.btnNext.isEnabled = !isLast
    }

    fun setOnPrevClick(listener: View.OnClickListener) {
        binding.btnPrevious.setOnClickListener(listener)
    }

    fun setOnNextClick(listener: View.OnClickListener) {
        binding.btnNext.setOnClickListener(listener)
    }
}