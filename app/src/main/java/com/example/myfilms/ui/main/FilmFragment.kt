package com.example.myfilms.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myfilms.databinding.FilmFragmentBinding
import com.example.myfilms.model.Films
import com.example.myfilms.viewmodel.AppState
import com.example.myfilms.viewmodel.FilmViewModel

class FilmFragment : Fragment() {

    private var _binding: FilmFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = FilmFragment()
    }

    private lateinit var viewModel: FilmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FilmFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilmViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, { dataFilm(it) })
        viewModel.getFilmLocal()
    }

    //отображаем данные
    private fun dataFilm(appState: AppState) {

        when (appState) {
            is AppState.Loading -> {
                Toast.makeText(context, "Загрузка данных", Toast.LENGTH_LONG).show()
            }
            is AppState.Success -> {
                val filmData = appState.weatherData
                setData(filmData)
            }
            is AppState.Error -> {
                Toast.makeText(context, "Нет подключения к интернету", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setData(filmData: Films) {
        binding.textNameFilm.text = filmData.name
        binding.ratingText.text = filmData.rating.toString()
        binding.rengeText.text = filmData.genre
        binding.descripText.text = filmData.descript
        binding.dateText.text = filmData.filmDate.toString()
    }

}