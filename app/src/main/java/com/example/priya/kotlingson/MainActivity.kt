package com.example.priya.kotlingson

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show()
            return
        }

        val recyclerView = findViewById(R.id.mv_recycler) as RecyclerView?
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        val apiService = ApiClient.client.create<ApiInterface>(ApiInterface::class.java!!)

        val call = apiService.getTopRatedMovies(API_KEY)
        call.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                val statusCode = response.code()
                val movies = response.body().results
                recyclerView.adapter = MoviesAdapter(movies!!, R.layout.list_item_movies, getApplicationContext())
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                // Log error here since request failed
                Log.e(TAG, t.toString())
            }
        })
    }

    companion object {

        private val TAG = MainActivity::class.java!!.getSimpleName()


        // TODO - insert your themoviedb.org API KEY here
        private val API_KEY = "7e8f60e325cd06e164799af1e317d7a7"
    }
}
