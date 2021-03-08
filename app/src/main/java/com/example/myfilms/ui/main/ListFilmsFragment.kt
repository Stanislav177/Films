package com.example.myfilms.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfilms.R
import com.example.myfilms.viewmodel.ListFilmsViewModel

class ListFilmsFragment : Fragment() {

    companion object {
        fun newInstance() = ListFilmsFragment()
    }

    private lateinit var viewModel: ListFilmsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_films_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListFilmsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}