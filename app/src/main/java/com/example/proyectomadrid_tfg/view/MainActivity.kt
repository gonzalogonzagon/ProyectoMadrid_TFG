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
import com.example.proyectomadrid_tfg.view.dialog.HelpDialogFragment

class MainActivity : AppCompatActivity() {

    // View binding for the main activity layout
    private lateinit var binding: ActivityMainBinding

    //Navigation controller for managing navigation between fragments
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the activity layout and set it as the content view
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check if it's the first launch
        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val firstLaunch = prefs.getBoolean("first_launch", true)
        if (firstLaunch) {
            HelpDialogFragment().show(supportFragmentManager, "HelpDialog")
            prefs.edit().putBoolean("first_launch", false).apply()
        }

        // Initialize UI components and navigation
        initUI()
    }

    /**
     * Initializes the main UI components, including navigation and floating action buttons.
     */
    private fun initUI() {
        initNavigation()
        setupFabBack()
        setupFabHelp()
    }

    /**
     * Sets up navigation and manages the visibility of the bottom navigation bar and FABs
     * based on the current navigation destination.
     */
    private fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment_activity_main
        ) as? NavHostFragment ?: run {
            handleError("NavHostFragment no encontrado")
            return
        }

        navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)

        // Listen for navigation destination changes to update UI visibility
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_collection_list,
                R.id.navigation_detail_poi -> setNavVisibility(
                    navVisible = false,
                    fabVisible = true
                )

                R.id.navigation_map -> {
                    // Hide navigation bar if coming from detail view
                    val fromDetail =
                        navController.previousBackStackEntry?.destination?.id == R.id.navigation_detail_poi
                    setNavVisibility(!fromDetail, fromDetail)
                }
                // Show navigation bar and hide FAB for all other destinations
                else -> setNavVisibility(navVisible = true, fabVisible = false)
            }
        }
    }

    /**
     * Sets up the back Floating Action Button (FAB) to navigate up in the navigation stack.
     */
    private fun setupFabBack() {
        binding.fabBack.setOnClickListener {
            navController.navigateUp()
        }
    }

    /**
     * Sets up the help Floating Action Button (FAB) to display the help dialog.
     */
    private fun setupFabHelp() {
        binding.fabHelp.setOnClickListener {
            HelpDialogFragment().show(supportFragmentManager, "HelpDialog")
        }
    }

    /**
     * Sets the visibility of the bottom navigation bar and back FAB.
     *
     * @param navVisible Whether the navigation bar should be visible.
     * @param fabVisible Whether the back FAB should be visible.
     */
    private fun setNavVisibility(navVisible: Boolean, fabVisible: Boolean) {
        binding.navView.visibility = if (navVisible) View.VISIBLE else View.GONE
        binding.fabBack.visibility = if (fabVisible) View.VISIBLE else View.GONE
    }

    /**
     * Handles errors by displaying a Toast and logging the error message.
     *
     * @param message The error message to display and log.
     */
    private fun handleError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        Log.e("MainActivity", message)
    }
}