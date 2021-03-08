package com.example.myfilms.ui.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.myfilms.R
import com.example.myfilms.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(getLayoutInflater())
        val view = binding.getRoot()
        setContentView(view)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_conteiner, FilmFragment.newInstance())
                    .commitNow()
        }
        initMenu()
    }

    private fun initMenu() {
        // Добавляем тулбар на активити
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Инициализация пунктов меню тулбар
        val inflater = menuInflater
        inflater.inflate(R.menu.app_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}