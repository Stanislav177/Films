package com.example.myfilms.viewmodel

import com.example.myfilms.model.Films

sealed class AppState {
    data class Success(val weatherData: Films) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
