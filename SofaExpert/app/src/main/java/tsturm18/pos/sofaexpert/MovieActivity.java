package tsturm18.pos.sofaexpert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra("movie");

        TextView name = findViewById(R.id.movieTitel);
        name.setText(movie.getTitle());
        TextView stars = findViewById(R.id.rating);
        stars.setText(String.valueOf(movie.getVote_average()) + " / 10");
        ImageView image = findViewById(R.id.poster);
        Picasso.get().load("http://image.tmdb.org/t/p/w154/"+movie.getPoster()).into(image);

        TextView releaseDate = findViewById(R.id.releaseDate);
        releaseDate.setText(movie.getRelease_date());

        TextView review = findViewById(R.id.description);
        review.setText(movie.getDescription());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}