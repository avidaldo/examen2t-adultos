package com.avidaldo.examen2tadultos21.navdrawer.ui.inicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.avidaldo.examen2tadultos21.databinding.FragmentJuegoInicioBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentJuegoInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentJuegoInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavJuego())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}