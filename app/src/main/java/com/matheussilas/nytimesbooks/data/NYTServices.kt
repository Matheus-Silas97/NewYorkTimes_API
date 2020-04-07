package com.matheussilas.nytimesbooks.data

import com.matheussilas.nytimesbooks.data.model.Book
import retrofit2.Call
import retrofit2.http.GET

interface NYTServices {

    @GET("lists.json")
    fun listRepos(): Call<List<>>

}