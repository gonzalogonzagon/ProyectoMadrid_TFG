package com.example.proyectomadrid_tfg.view.list

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.proyectomadrid_tfg.databinding.FragmentDetailPoiListBinding
import com.example.proyectomadrid_tfg.model.collection.CollectableProvider
import com.example.proyectomadrid_tfg.model.poi_list.PointOfInterest
import com.example.proyectomadrid_tfg.model.poi_list.PointOfInterestProvider

class DetailPOIListFragment : Fragment() {

    private var _binding: FragmentDetailPoiListBinding? = null
    private val binding get() = _binding!!
    private val args: DetailPOIListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailPoiListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Aquí puedes obtener los argumentos y mostrar la información detallada
        val pointOfInterestTitle = args.pointOfInterestId
        val isFromMap = args.fromMap
        val isFromPostcard = args.fromPostcard
        val isFromCollection = args.fromCollection

        // Buscar en la lista principal de POIs
        val pointOfInterest = PointOfInterestProvider.pointOfInterestList.find {
            it.title == pointOfInterestTitle
        }
        // Si no se encuentra, buscar en los poiList de CollectableProvider
            ?: CollectableProvider.collectableObjects
                .asSequence()
                .filter { !it.poiList.isNullOrEmpty() }
                .mapNotNull { it.poiList }
                .flatten()
                .find { it.title == pointOfInterestTitle }
            // Si tampoco se encuentra, buscar en los collectables cuyo poiList es null o vacía y comparar con su poi
            ?: CollectableProvider.collectableObjects
                .asSequence()
                .filter { it.poiList.isNullOrEmpty() }
                .mapNotNull { it.poi }
                .find { it.title == pointOfInterestTitle }

        if (pointOfInterest != null) {
            initUI(pointOfInterest, isFromMap, isFromPostcard, isFromCollection)
        } else {
            showErrorState("No se pudo encontrar el punto de interés seleccionado")
        }
    }

    private fun initUI(pointOfInterest: PointOfInterest, fromMap : Boolean, fromPostcard : Boolean, fromCollection : Boolean) {
        binding.apply {
            ivPoiDetailImage.setImageResource(pointOfInterest.image)
            tvPoiDetailTitle.setText(pointOfInterest.title)
            tvPoiDetailSubtitle.setText(pointOfInterest.subtitle)
            categoryIndicatorDetail.setBackgroundColor(
                ContextCompat.getColor(requireContext(), pointOfInterest.category)
            )

            // Configurar el botón de RA (si lo quieres usar para otra función, puedes modificarlo)
            btnARExperience.setOnClickListener {
                // Implementar acción para mostrar en mapa o experiencia AR
            }

            btnARExperienceRemote.setOnClickListener {
                // Implementar acción para mostrar en mapa o experiencia AR
            }

            if (pointOfInterest.detailPointOfInterest != null) {
                // Descripción 1
                pointOfInterest.detailPointOfInterest.detailedDescription?.let {
                    tvPoiDescription2.setText(it)
                    tvPoiDescription2.visibility = View.VISIBLE
                } ?: run {
                    tvTitleDescription.visibility = View.GONE
                    tvPoiDescription2.visibility = View.GONE
                }

                // Descripción 2
                pointOfInterest.detailPointOfInterest.detailedDescription2?.let {
                    tvPoiDescription3.setText(it)
                    tvPoiDescription3.visibility = View.VISIBLE
                } ?: run {
                    tvPoiDescription3.visibility = View.GONE
                }

                // Imagen adicional
                pointOfInterest.detailPointOfInterest.detailImages?.let {
                    ivDescriptionImage.setImageResource(it)
                    ivDescriptionImage.visibility = View.VISIBLE
                } ?: run {
                    ivDescriptionImage.visibility = View.GONE
                }
            } else {
                tvTitleDescription.visibility = View.GONE
                tvPoiDescription2.visibility = View.GONE
                tvPoiDescription3.visibility = View.GONE
                ivDescriptionImage.visibility = View.GONE
            }

            // Mostrar tutorial de ayuda si existe
            pointOfInterest.detailPointOfInterest?.assistTutorial?.let {
                tvTextTutorial.setText(it)
                tvTextTutorial.visibility = View.VISIBLE
            } ?: run {
                tvTextTutorial.visibility = View.GONE
            }
            pointOfInterest.detailPointOfInterest?.assistTutorialImage?.let {
                ivTutorialImage.setImageResource(it)
                ivTutorialImage.visibility = View.VISIBLE
            } ?: run {
                ivTutorialImage.visibility = View.GONE
            }

            if (pointOfInterest.detailPointOfInterest?.wikiUrl != null) {
                binding.tvTextLinks.text = "Consulta más información pulsando aquí"
                binding.tvTextLinks.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pointOfInterest.detailPointOfInterest.wikiUrl.let { getString(it) }))
                    startActivity(intent)
                }
            }

            if (fromPostcard || fromCollection) {
                btnARExperienceRemote.visibility = View.GONE
            }

            // Handle Show on Map button visibility
            if (fromMap) {
                // Hide the button if we came from the map to avoid navigation loops
                fabShowOnMap.visibility = View.GONE
            } else {
                fabShowOnMap.visibility = View.VISIBLE
                fabShowOnMap.setOnClickListener {
                    val action =
                        DetailPOIListFragmentDirections.actionNavigationDetailPoiToNavigationMap(
                            pointOfInterest.title
                        )
                    findNavController().navigate(action)
                }
            }
        }
    }

    private fun showErrorState(message: String) {
        binding.apply {
            // Ocultar las vistas normales
            ivPoiDetailImage.visibility = View.GONE
            categoryIndicatorDetail.visibility = View.GONE
            // etc.

            // Mostrar mensaje de error
            // Aquí deberías tener una vista para mostrar errores
            tvError.text = message
            tvError.visibility = View.VISIBLE
        }
    }
}