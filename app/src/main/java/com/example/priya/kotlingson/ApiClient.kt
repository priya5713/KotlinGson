package com.example.priya.kotlingson

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Priya on 26-05-2017.
 */
object ApiClient {

    val BASE_URL = "http://api.themoviedb.org/3/"
    private var retrofit: Retrofit? = null


    val client: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!
        }
}
