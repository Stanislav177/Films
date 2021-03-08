package com.example.myfilms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfilms.model.Repository
import com.example.myfilms.model.RepositoryImp
import java.lang.Thread.sleep
import kotlin.random.Random

class FilmViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImp: Repository = RepositoryImp()
) : ViewModel() {

    fun getLiveData(): LiveData<AppState> = liveDataToObserve
    fun getFilmLocal() = getDataFromLocal()

    //Метод для запроса данных
    private fun getDataFromLocal() {
        //Имитируем состояние сети четное число есть сеть, не четное нет сети
        val myRandomInt = Random.nextInt(4)
        val myNumberInt = 2
        val resInt = myRandomInt % myNumberInt
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(5000)
            if (resInt == 0) {
                liveDataToObserve.postValue(AppState.Success(repositoryImp.getFilmsDataFromLocal()))
            } else {
                liveDataToObserve.postValue(AppState.Error(Throwable("Нет сети")))
            }

        }.start()
    }
}