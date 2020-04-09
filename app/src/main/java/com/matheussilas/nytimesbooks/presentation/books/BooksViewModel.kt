package com.matheussilas.nytimesbooks.presentation.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheussilas.nytimesbooks.data.ApiService
import com.matheussilas.nytimesbooks.data.model.Book
import com.matheussilas.nytimesbooks.data.response.BookBodyResponse
import com.matheussilas.nytimesbooks.data.response.BookResultsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {


    fun getBooks(): LiveData<BookBodyResponse> {
        val bookLiveData: MutableLiveData<BookBodyResponse> = MutableLiveData()

        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if (response.isSuccessful) {
                    bookLiveData.value = response.body()

                }

            }

        })
        return bookLiveData
    }

}