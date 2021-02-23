package tsturm18.pos.sofaexpert;


import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class Movie implements Parcelable {

    double vote_average;
    String title;
    String poster;
    String description;
    String release_date;
    RequestCreator image;



    public Movie(double vote_average, String title, String poster, String description, String release_date) {
        this.vote_average = vote_average;
        this.title = title;
        this.poster = poster;
        this.description = description;
        this.release_date = release_date;
    }

    protected Movie(Parcel in) {
        vote_average = in.readDouble();
        title = in.readString();
        poster = in.readString();
        description = in.readString();
        release_date = in.readString();
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(getVote_average());
        dest.writeString(getTitle());
        dest.writeString(getPoster());
        dest.writeString(getDescription());
        dest.writeString(getRelease_date());
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
