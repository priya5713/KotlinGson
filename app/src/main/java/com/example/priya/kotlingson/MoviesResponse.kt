package com.example.priya.kotlingson

import com.google.gson.annotations.SerializedName

/**
 * Created by Priya on 26-05-2017.
 */
class MoviesResponse {
    @SerializedName("page")
    var page: Int = 0
    @SerializedName("results")
    var results: List<Movie>? = null
    @SerializedName("total_results")
    var totalResults: Int = 0
    @SerializedName("total_pages")
    var totalPages: Int = 0
}
