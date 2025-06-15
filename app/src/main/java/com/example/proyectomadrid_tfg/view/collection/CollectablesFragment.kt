package com.example.proyectomadrid_tfg.view.collection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectomadrid_tfg.databinding.FragmentCollectablesBinding
import com.example.proyectomadrid_tfg.model.collection.CollectableProvider
import com.example.proyectomadrid_tfg.viewmodel.collection.CollectablesAdapter

/**
 * A simple [Fragment] subclass.
 */
class CollectablesFragment : Fragment() {

    private var _binding: FragmentCollectablesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterCollectables: CollectablesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCollectablesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapterCollectables = CollectablesAdapter(
            CollectableProvider.collectableObjects
        ) { collectable ->
            if (!collectable.poiList.isNullOrEmpty()) {
                val action =
                    CollectablesFragmentDirections.actionNavigationCollectionToNavigationCollectionList(collectable.title)
                findNavController().navigate(action)
            } else if (collectable.poi != null) {
                val action =
                    CollectablesFragmentDirections.actionNavigationCollectionToNavigationDetailPoi(collectable.poi.title, fromPostcard = false, fromCollection = true)
                findNavController().navigate(action)
            }
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterCollectables
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}