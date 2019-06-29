package com.codepath.movielistactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codepath.movielistactivity.models.Movie;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {

    //the movie and the details that we want from it
    Movie movie;
    TextView tvTitle;
    TextView tvOverview;
    TextView releaseDate;
    RatingBar rbVoteAverage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        //resolve the view objects
        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        rbVoteAverage = findViewById(R.id.rbVoteAverage);
        releaseDate = findViewById(R.id.releaseDate);

        //unwrap the movie passed in via intent, using its simple name as a key
        movie = Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MoviesDetailActivity", String.format("Showing details for %s", movie.getTitle()));

        //set title
        tvTitle.setText(movie.getTitle());
        //set overview
        tvOverview.setText(movie.getOverview());
        //set average
        float voteAverage = movie.getVoteAverage().floatValue();
        rbVoteAverage.setRating(voteAverage = voteAverage > 0 ? voteAverage / 2.0f : voteAverage);
        //set popularity
        releaseDate.setText(movie.getReleaseDate());
    }
}
