package com.avidaldo.examen2tadultos21.navdrawer.ui.ganador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.avidaldo.examen2tadultos21.databinding.FragmentGanadorBinding

class GanadorFragment : Fragment() {
    private var _binding: FragmentGanadorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGanadorBinding.inflate(inflater, container, false)

        val ganadorViewModel =
            ViewModelProvider(this)[GanandorViewModel::class.java]


        ganadorViewModel.text.observe(viewLifecycleOwner) {
            binding.textSlideshow.text = it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}