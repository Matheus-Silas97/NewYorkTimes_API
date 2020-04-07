package com.matheussilas.nytimesbooks.presentation.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheussilas.nytimesbooks.data.model.Book

class BooksViewModel : ViewModel() {

    val bookLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        bookLiveData.value = createFakeBooks()

    }

    fun createFakeBooks(): List<Book> {
        return listOf(
            Book("title 1", "author 1"),
            Book("title 2", "author 2"),
            Book("title 3", "author 3")
        )

    }
}