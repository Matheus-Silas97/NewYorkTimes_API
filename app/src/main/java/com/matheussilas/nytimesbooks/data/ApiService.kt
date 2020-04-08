package com.matheussilas.nytimesbooks.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


object ApiService {

        var retrofit: Retrofit? = null
        val retrofitInstance: Retrofit?
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl("https://api.nytimes.com/svc/books/v3/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit
            }

        val service: NYTServices = retrofitInstance!!.create(NYTServices::class.java)
    }
