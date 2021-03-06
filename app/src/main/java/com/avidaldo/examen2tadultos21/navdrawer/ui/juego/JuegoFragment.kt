package com.avidaldo.examen2tadultos21.navdrawer.ui.juego

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.avidaldo.examen2tadultos21.databinding.FragmentJuegoBinding

class JuegoFragment : Fragment() {
    private var _binding: FragmentJuegoBinding? = null
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private lateinit var modelo: TresEnRayaModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentJuegoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        modelo = TresEnRayaModel()
        binding.buttonGrid.setOnClickListener(::onCellClicked)

        binding.buttonReset.setOnClickListener {
            reset()
        }
    }

    private fun GridLayout.setOnClickListener(onClick: (Button) -> Unit) {
        for (i in 0 until childCount) {
            val boton = getChildAt(i) as Button
            boton.setOnClickListener {
                onClick(boton)
            }
        }
    }

    private fun onCellClicked(button: Button) {
        val tag = button.tag.toString().toCharArray()
        val row = tag[0].digitToInt()
        val col = tag[1].digitToInt()

        if (modelo.jugarTurno(row, col)) {
            binding.buttonReset.visibility = View.VISIBLE
            button.text = modelo.getplayerInCell(row,col).toString()
            modelo.ganador?.let{
                findNavController().navigate(JuegoFragmentDirections.actionNavJuegoToNavGanador(it.toString()))
                reset()
            }
        }
    }

    private fun reset() {
        modelo.reiniciar()
        for (i in 0 until binding.buttonGrid.childCount) {
            (binding.buttonGrid.getChildAt(i) as Button).text = null
        }
        binding.buttonReset.visibility = View.GONE
    }


}