package com.example.proyectomadrid_tfg.view.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.proyectomadrid_tfg.databinding.DialogHelpBinding
import com.example.proyectomadrid_tfg.model.help_dialog.HelpTipProvider
import com.example.proyectomadrid_tfg.viewmodel.help_dialog.HelpDialogAdapter
import com.example.proyectomadrid_tfg.viewmodel.help_dialog.HelpDialogViewHolder

class HelpDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogHelpBinding.inflate(requireActivity().layoutInflater)
        val viewHolder = HelpDialogViewHolder(binding.root)
        val adapter = HelpDialogAdapter(HelpTipProvider.helpTipLists)

        fun update() {
            viewHolder.bind(
                adapter.getCurrentPage(),
                adapter.isFirstPage(),
                adapter.isLastPage()
            )
        }

        viewHolder.setOnPrevClick {
            adapter.prevPage()
            update()
        }
        viewHolder.setOnNextClick {
            adapter.nextPage()
            update()
        }

        update()

        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .setCancelable(true)
            .create()
    }
}