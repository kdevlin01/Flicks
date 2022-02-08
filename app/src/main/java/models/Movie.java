package models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String backdropPath;
    String posterPath;
    String title;
    String overview;

    public Movie (JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title =  jsonObject.getString("title");
        overview = jsonObject.getString("overview");
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
}
