package tsturm18.pos.sofaexpert;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    Activity activity;
    List<Movie> movies;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = readJSON();
        loadMovieCovers();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<Movie> readJSON(){
        movies = new ArrayList<Movie>();
        try {
            String content = new BufferedReader(new InputStreamReader(getAssets().open("movies.json"))).lines().collect(Collectors.joining((CharSequence)"\n"));
            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonArray = jsonObject.getJSONArray("results");



            for (int i = 0; i <jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                movies.add(new Movie(object.getDouble("vote_average"),
                        object.getString("title"),
                        object.getString("poster_path"),
                        object.getString("overview"),
                        object.getString("release_date")));
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }

    private void loadMovieCovers(){
        GridView movies = findViewById(R.id.gridView_movies);
        movies.setAdapter(new MovieAdapter(this, this.movies, R.layout.movie_layout));

        movies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startIntent(position);
            }
        });
    }

    private void startIntent(int position){
        Intent intent = new Intent(this,MovieActivity.class);
        intent.putExtra("movie",movies.get(position));
        startActivity(intent);
    }

}