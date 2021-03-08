package com.example.myfilms.model

class RepositoryImp : Repository {
    override fun getFilmsDataFromLocal(): Films {
        return Films()
    }

    override fun getFilmsDataFromServer(): Films {
        return Films()
    }
}