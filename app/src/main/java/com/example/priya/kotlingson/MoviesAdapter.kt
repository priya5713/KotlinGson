package com.example.priya.kotlingson

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by Priya on 26-05-2017.
 */
class MoviesAdapter(private val movies: List<Movie>, private val rowLayout: Int, private val context: Context) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {


    class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal var moviesLayout: LinearLayout
        internal var movieTitle: TextView
        internal var data: TextView
        internal var movieDescription: TextView
        internal var rating: TextView


        init {
            moviesLayout = v.findViewById(R.id.movies_layout) as LinearLayout
            movieTitle = v.findViewById(R.id.title) as TextView
            data = v.findViewById(R.id.subtitle) as TextView
            movieDescription = v.findViewById(R.id.description) as TextView
            rating = v.findViewById(R.id.rating) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MoviesAdapter.MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return MovieViewHolder(view)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieTitle.text = movies[position].title
        holder.data.text = movies[position].releaseDate
        holder.movieDescription.text = movies[position].overview
        holder.rating.text = movies[position].voteAverage!!.toString()
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}




