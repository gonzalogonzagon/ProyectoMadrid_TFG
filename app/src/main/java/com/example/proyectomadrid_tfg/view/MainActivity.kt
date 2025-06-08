package com.example.proyectomadrid_tfg.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.proyectomadrid_tfg.R
import com.example.proyectomadrid_tfg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    // (Made by user) Function to initialize the UI and call other functions
    private fun initUI() {
        initNavigation()
        setupFabBack()
    }

    // (Made by user) Function to initialize the navigation
    private fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment_activity_main
        ) as? NavHostFragment

        if (navHostFragment != null) {
            navController = navHostFragment.navController
            binding.navView.setupWithNavController(navController)

            // Actualizar el título según cambia la navegación
            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.navigation_collection_list -> {
                        binding.navView.visibility = View.GONE
                        binding.fabBack.visibility = View.VISIBLE
                    }
                    R.id.navigation_detail_poi -> {
                        // Hide bottom navigation and show back button when in detail view
                        binding.navView.visibility = View.GONE
                        binding.fabBack.visibility = View.VISIBLE
                    }
                    R.id.navigation_map -> {
                        // Check if coming from detail view (need to keep navView hidden)
                        val fromDetail = navController.previousBackStackEntry?.destination?.id == R.id.navigation_detail_poi
                        if (fromDetail) {
                            binding.navView.visibility = View.GONE
                            binding.fabBack.visibility = View.VISIBLE
                        } else {
                            binding.navView.visibility = View.VISIBLE
                            binding.fabBack.visibility = View.GONE
                        }
                    }
                    else -> {
                        // For all other destinations, show bottom navigation and hide back button
                        binding.navView.visibility = View.VISIBLE
                        binding.fabBack.visibility = View.GONE
                    }
                }
            }
        } else {
            handleError("NavHostFragment no encontrado")
        }
    }

    private fun setupFabBack() {
        binding.fabBack.setOnClickListener {
            navController.navigateUp()
        }
    }

    private fun handleError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        Log.e("MainActivity", message)
    }
}