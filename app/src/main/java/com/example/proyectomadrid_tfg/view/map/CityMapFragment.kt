package com.example.proyectomadrid_tfg.view.map

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.proyectomadrid_tfg.BuildConfig
import com.example.proyectomadrid_tfg.R
import com.example.proyectomadrid_tfg.databinding.FragmentCityMapBinding
import com.example.proyectomadrid_tfg.model.poi_list.PointOfInterestProvider
import org.osmdroid.config.Configuration
import org.osmdroid.events.MapEventsReceiver
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.BoundingBox
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.CopyrightOverlay
import org.osmdroid.views.overlay.MapEventsOverlay
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.infowindow.InfoWindow

/**
 * A simple [Fragment] subclass.
 */
class CityMapFragment : Fragment() {

    private var _binding: FragmentCityMapBinding? = null
    private val binding get() = _binding!!
    private lateinit var map: MapView

    private val args: CityMapFragmentArgs by navArgs()

    private var currentPoi: Marker? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Load/initialize the osmdroid configuration
        Configuration.getInstance()
            .load(context, context.getSharedPreferences("osmdroid", Context.MODE_PRIVATE))
        //   Set the User-Agent value
        Configuration.getInstance().userAgentValue = BuildConfig.APPLICATION_ID
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCityMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize and configure UI components here
        setupMap()

        // Verify if there are args
        val selectedPoiId = args.pointOfInterestId

        // Decidir qué marcadores mostrar según argumentos
        if (selectedPoiId != 0) {
            // Si hay un POI seleccionado y estamos en modo de marcador único,
            // mostramos solo ese marcador
            addSingleMarker(selectedPoiId)
        } else {
            // En caso contrario, mostramos todos los marcadores
            addPOIMarkers()
        }
    }

    private fun setupMap() {
        // Initialize the Map
        map = binding.map

        // Set the tile source explicitly
        map.setTileSource(TileSourceFactory.MAPNIK)

        map.setMultiTouchControls(true)
        // Disable zoom buttons
        map.zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)

        // Set minimum and maximum zoom levels
        map.minZoomLevel = 13.0
        map.maxZoomLevel = 20.5

        // Set initial zoom level and center point
        map.controller.setZoom(15.8)
        val startPoint = GeoPoint(40.416775, -3.703790) // Coordinates for Madrid
        map.controller.setCenter(startPoint)

        // Define the bounding box for the Comunidad de Madrid
        val boundingBox = BoundingBox(
            40.5,
            -3.6,
            40.3,
            -3.8
        )
        // Set the scrollable area limit
        map.setScrollableAreaLimitDouble(boundingBox)

        // Add OpenStreetMap credit overlay
        addCreditOverlay()

        // Add map click listener to close info windows
        val mapEventsReceiver = object : MapEventsReceiver {
            override fun singleTapConfirmedHelper(p: GeoPoint?): Boolean {
                InfoWindow.closeAllInfoWindowsOn(map)
                currentPoi = null
                return true
            }

            override fun longPressHelper(p: GeoPoint?): Boolean {
                return false
            }
        }
        val mapEventsOverlay = MapEventsOverlay(mapEventsReceiver)
        map.overlays.add(mapEventsOverlay)
    }

    private fun addCreditOverlay() {
        val copyrightNotice = map.tileProvider.tileSource.copyrightNotice
        val copyrightOverlay = CopyrightOverlay(context)
        copyrightOverlay.setCopyrightNotice(copyrightNotice)
        map.overlays.add(copyrightOverlay)
    }

    private fun getCategoryIconMap(): Map<Int, Int> {
        // Mapeo de categorías a recursos de drawable
        return mapOf(
            R.color.dark_gray to R.drawable.ic_marker_monument_32px,
            R.color.error to R.drawable.ic_marker_selected_32px,
            R.color.gray to R.drawable.ic_marker_monument_32px,
            R.color.light_gray to R.drawable.ic_marker_selected_copia2,
            R.color.black to R.drawable.ic_marker_monument_32px
        )
    }

    private fun addSingleMarker(pointOfInterestId: Int) {
        val poi = PointOfInterestProvider.pointOfInterestList.find { it.title == pointOfInterestId }
            ?: return

        val categoryIconMap = getCategoryIconMap()

        val marker = Marker(map).apply {
            position = GeoPoint(poi.latitude, poi.longitude)
            title = getString(poi.title)
            snippet = getString(poi.description)

            // Asignar icono según categoría
            icon = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_marker_selected_32px
            )

            // Configuración adicional
            setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            infoWindow = CustomInfoWindow(map, poi, true)
        }

        marker.setOnMarkerClickListener { _, _ ->

            // Center the map on the selected marker
            map.controller.animateTo(marker.position)

            // Open the new info window
            marker.showInfoWindow()
            currentPoi = marker
            true
        }

        map.overlays.add(marker)
        map.invalidate()

        val point = GeoPoint(poi.latitude, poi.longitude)

        // Zoom and animate to the point
        map.controller.setZoom(18.8)
        map.controller.animateTo(point)
    }

    private fun addPOIMarkers() {
        // Mapeo de categorías a recursos de drawable
        val categoryIconMap = getCategoryIconMap()

        PointOfInterestProvider.pointOfInterestList.forEach { poi ->
            val marker = Marker(map).apply {
                position = GeoPoint(poi.latitude, poi.longitude)
                title = getString(poi.title)
                snippet = getString(poi.description)

                // Asignar icono según categoría
                icon = ContextCompat.getDrawable(
                    requireContext(),
                    categoryIconMap[poi.category] ?: R.drawable.baseline_child_friendly_24
                )

                // Configuración adicional
                setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                infoWindow = CustomInfoWindow(map, poi)
            }

            marker.setOnMarkerClickListener { _, _ ->
                // Close the last opened info window if it exists
                currentPoi?.infoWindow?.close()

                // Center the map on the selected marker
                map.controller.animateTo(marker.position)

                // Open the new info window
                marker.showInfoWindow()
                currentPoi = marker
                true
            }

            map.overlays.add(marker)
        }
        // Refresca el mapa
        map.invalidate()
    }

//    // Nueva función para mostrar un POI seleccionado basado en su ID
//    private fun showSelectedPoi(poiId: Int) {
//        // Busca el título del POI basado en su ID
//        val poiTitle = getString(poiId)
//
//        // Busca entre todos los overlays por un marcador con ese título
//        val foundMarker = map.overlays
//            .filterIsInstance<Marker>()
//            .find { it.title == poiTitle }
//
//        if (foundMarker != null) {
//            // Cerrar cualquier InfoWindow abierta
//            InfoWindow.closeAllInfoWindowsOn(map)
//
//            // Centrar el mapa en la posición del marcador
//            map.controller.setZoom(17.0)  // Zoom adecuado para ver bien el POI
//            map.controller.animateTo(foundMarker.position)
//
//            // Mostrar el InfoWindow
//            foundMarker.showInfoWindow()
//
//            // Actualizar el POI actual
//            currentPoi = foundMarker
//        }
//    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        map.onDetach()
        _binding = null
    }
}