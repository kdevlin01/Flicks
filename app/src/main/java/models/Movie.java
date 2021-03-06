package models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    int movieId;
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;
    int voteCount;
    String releaseDate;
    double popularity;




    public Movie() {}   //Needed for parceler library

    public Movie (JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title =  jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
        voteCount = jsonObject.getInt("vote_count");
        releaseDate = jsonObject.getString("release_date");
        popularity = jsonObject.getDouble("popularity");
    }
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i ++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }
//    public List<String> getPosterSizes{
//
//    }

    public int getMovieId() {
        return movieId;
    }

    public String getBackdropPath() {
        return (String.format("https://image.tmdb.org/t/p/original/%s",backdropPath)) ;
    }

    public String getPosterPath() {
        return (String.format("https://image.tmdb.org/t/p/original/%s",posterPath)); //need to edit this
    }


    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getPopularity() {
        return popularity;
    }
}
