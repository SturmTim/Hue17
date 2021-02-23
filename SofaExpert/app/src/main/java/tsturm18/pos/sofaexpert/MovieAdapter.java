package tsturm18.pos.sofaexpert;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends BaseAdapter {

    List<Movie> movieList = new ArrayList<>();
    private int layoutId;
    private LayoutInflater inflater;

    public MovieAdapter(Context context, List<Movie> movieList, int layoutId) {
        this.movieList = movieList;
        this.layoutId = layoutId;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = movieList.get(position);
        View listItem = (convertView == null) ? inflater.inflate(this.layoutId, null) : convertView;

        ImageView imgView =  listItem.findViewById(R.id.imageView_movie);

        Picasso.get().load("http://image.tmdb.org/t/p/w154/"+movie.getPoster()).into(imgView);

        return listItem;
    }
}
