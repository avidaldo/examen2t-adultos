package com.avidaldo.examen2tadultos21.navdrawer.ui.juego

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.avidaldo.examen2tadultos21.databinding.FragmentJuegoBinding

class JuegoFragment : Fragment() {
    private var _binding: FragmentJuegoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentJuegoBinding.inflate(inflater, container, false)


        val juegoViewModel =
            ViewModelProvider(this)[JuegoViewModel::class.java]


        juegoViewModel.text.observe(viewLifecycleOwner) {
           // binding.textGallery.text = it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}