package com.example.proyectomadrid_tfg.view.map

import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.proyectomadrid_tfg.R
import com.example.proyectomadrid_tfg.databinding.ItemPoiInfoWindowBinding
import com.example.proyectomadrid_tfg.model.poi_list.PointOfInterest
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.infowindow.InfoWindow

/**
 * A simple [Fragment] subclass.
 */
class CustomInfoWindow(mapView: MapView, private val pointOfInterest: PointOfInterest, private val singleMarker: Boolean = false) :
    InfoWindow(R.layout.item_poi_info_window, mapView) {

    private val binding: ItemPoiInfoWindowBinding = ItemPoiInfoWindowBinding.bind(mView)

    override fun onOpen(item: Any?) {
        // Cast the item to Marker if possible
        val marker = item as? Marker ?: return

        binding.apply {
            tvPoiTitle.text = marker.title
            tvPoiDescription.text = marker.snippet
            ivPoiImage.setImageResource(pointOfInterest.image)
            categoryIndicator.setBackgroundColor(
                ContextCompat.getColor(
                    root.context,
                    pointOfInterest.category
                )
            )
        }

        // Close button handler
        mView.findViewById<View>(R.id.btnClosePopup).setOnClickListener {
            close()
        }

        if (!singleMarker) {
            binding.root.setOnClickListener {
                val action =
                    CityMapFragmentDirections.actionNavigationMapToNavigationDetailPoi(
                        pointOfInterest.title,
                        fromMap = true
                    )
                it.findNavController().navigate(action)
            }
        }
    }

    override fun onClose() {
        // Clean up resources if needed
    }
}