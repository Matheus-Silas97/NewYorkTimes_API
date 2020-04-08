package com.matheussilas.nytimesbooks.presentation.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheussilas.nytimesbooks.data.ApiService
import com.matheussilas.nytimesbooks.data.model.Book
import com.matheussilas.nytimesbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val bookLiveData: MutableLiveData<BookBodyResponse> = MutableLiveData()

    fun getBooks(): LiveData<BookBodyResponse> {
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if (response.isSuccessful) {
                  /*  var results = List<Book>()
                    var teste = response!!.body().bookResults[0]*/
                }
            }

        })
    return bookLiveData
    }
}