package com.matheussilas.nytimesbooks.data

import com.matheussilas.nytimesbooks.data.model.Book
import com.matheussilas.nytimesbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "M9rjrvz7e24VYlI051ko8buWAZvACP5e",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>

}