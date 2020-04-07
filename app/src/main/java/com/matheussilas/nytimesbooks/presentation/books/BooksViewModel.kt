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

    val bookLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->
                        for (result in bookBodyResponse.bookResults) {
                            val book: Book = Book(
                                title = result.bookDetails[0].title,
                                author = result.bookDetails[0].author
                            )
                            books.add(book)
                        }
                    }
                    bookLiveData.value = books
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}