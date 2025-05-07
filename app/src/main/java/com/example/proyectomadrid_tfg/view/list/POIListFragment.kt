package com.example.proyectomadrid_tfg.view.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectomadrid_tfg.databinding.FragmentPoiListBinding
import com.example.proyectomadrid_tfg.model.poi_list.PointOfInterestProvider
import com.example.proyectomadrid_tfg.viewmodel.poi_list.PointOfInterestAdapter

/**
 * A simple [Fragment] subclass.
 */
class POIListFragment : Fragment() {

    private var _binding: FragmentPoiListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterPoiList: PointOfInterestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPoiListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapterPoiList = PointOfInterestAdapter(
            PointOfInterestProvider.pointOfInterestList
        ) { pointOfInterest ->
            // Navegar al fragmento de detalle
            val action =
                POIListFragmentDirections.actionNavigationListToNavigationDetailPoi(pointOfInterest.title)
            findNavController().navigate(action)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterPoiList
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}