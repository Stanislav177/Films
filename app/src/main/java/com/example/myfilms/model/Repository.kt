package com.example.myfilms.model

interface Repository {
    fun getFilmsDataFromLocal(): Films
    fun getFilmsDataFromServer(): Films
}