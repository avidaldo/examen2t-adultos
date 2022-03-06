package com.avidaldo.examen2tadultos21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.avidaldo.examen2tadultos21.bottomnav.BottomNavActivity
import com.avidaldo.examen2tadultos21.databinding.ActivityMainBinding
import com.avidaldo.examen2tadultos21.navdrawer.NavDrawerActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavDrawer.setOnClickListener {
            startActivity(Intent(this, NavDrawerActivity::class.java))
        }

        binding.btnBottomNav.setOnClickListener {
            startActivity(Intent(this, BottomNavActivity::class.java))
        }

    }

}