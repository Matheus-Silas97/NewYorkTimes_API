package com.matheussilas.nytimesbooks.data.response

import com.google.gson.annotations.SerializedName


data class BookBodyResponse (
    @SerializedName("results")
    var bookResults: List<BookResultsResponse>
)