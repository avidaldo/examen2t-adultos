package com.avidaldo.examen2tadultos21.navdrawer

import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.avidaldo.examen2tadultos21.R
import com.avidaldo.examen2tadultos21.databinding.ActivityNavDrawerBinding

class NavDrawerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavDrawerBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNavDrawer.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_nav_drawer) as NavHostFragment
        navController = navHostFragment.navController

/*        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home, R.id.nav_juego, R.id.nav_ganador), binding.drawerLayout)*/

        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}