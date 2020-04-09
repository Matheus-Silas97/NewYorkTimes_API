package com.matheussilas.nytimesbooks.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheussilas.nytimesbooks.R
import com.matheussilas.nytimesbooks.data.model.Book
import com.matheussilas.nytimesbooks.data.response.BookDetailsResponse
import com.matheussilas.nytimesbooks.data.response.BookResultsResponse
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(val books: List<BookResultsResponse>) :
    RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.textTitle
        private val author = itemView.textAuthor

        fun bindView(book: BookResultsResponse) {
            title.text = book.bookDetails[0].title
            author.text = book.bookDetails[0].author
        }

    }

    //onde é criado a lista com item de layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(itemView)
    }

    //retorna a quantidade de itens da lista
    override fun getItemCount() = books.count()

    //ligação dos itens da lista com componentes do recycleview
    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(books[position])

    }
}