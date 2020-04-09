package com.matheussilas.nytimesbooks.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheussilas.nytimesbooks.R
import com.matheussilas.nytimesbooks.data.model.Book
import com.matheussilas.nytimesbooks.data.response.BookDetailsResponse
import com.matheussilas.nytimesbooks.data.response.BookResultsResponse
import com.matheussilas.nytimesbooks.presentation.books.BooksAdapter
import com.matheussilas.nytimesbooks.presentation.books.BooksViewModel
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        toolbarMain.title = getString(R.string.books_title)
        setSupportActionBar(toolbarMain)

        var viewModel: BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)
        viewModel.getBooks().observe(this, Observer {data ->
            var bookResult: List<BookResultsResponse> = data.bookResults
            var booksAdapter: BooksAdapter = BooksAdapter(bookResult)
            recycleBooks.adapter = booksAdapter
            recycleBooks.layoutManager = LinearLayoutManager(this)

        })
    }
}
