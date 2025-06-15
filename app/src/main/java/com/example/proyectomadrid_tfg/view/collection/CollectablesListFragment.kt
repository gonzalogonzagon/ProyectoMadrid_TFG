package com.example.proyectomadrid_tfg.view.collection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectomadrid_tfg.databinding.FragmentCollectablesListBinding
import com.example.proyectomadrid_tfg.model.collection.Collectable
import com.example.proyectomadrid_tfg.model.collection.CollectableProvider
import com.example.proyectomadrid_tfg.viewmodel.collection.CollectablesListAdapter


/**
 * A simple [Fragment] subclass.
 */
class CollectablesListFragment : Fragment() {

    private var _binding: FragmentCollectablesListBinding? = null
    private val binding get() = _binding!!
    private val args: CollectablesListFragmentArgs by navArgs()
    private lateinit var adapterCollectablesList: CollectablesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCollectablesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val collectableId = args.collectableListId

        val collectableList = CollectableProvider.collectableObjects.find {
            it.title == collectableId
        }

        if (collectableList != null)
            initRecyclerView(collectableList)
    }

    private fun initRecyclerView( collectable: Collectable) {
        adapterCollectablesList = CollectablesListAdapter(
            collectable.poiList ?: emptyList()
        ) { poi ->
            // Navegar al detalle del POI
            val action = CollectablesListFragmentDirections
                .actionNavigationCollectionListToNavigationDetailPoi(poi.title, fromPostcard = true, fromCollection = true)
            findNavController().navigate(action)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterCollectablesList
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}