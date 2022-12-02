package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
@Component
public class MovieRepository {
    HashMap<String, Movie> movies = new HashMap<>();
    HashMap<String, Director> directors = new HashMap<>();
    HashMap<String, String> movieDirectorPair = new HashMap<>();
    List<String> list = new ArrayList<>();


    public void addMovieinDB(Movie movie){
        movies.put(movie.getName(), movie);
    }

    public void addDirectorinDB(Director director){
        directors.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName){

        movieDirectorPair.put(movieName, directorName);
    }

    public Movie getMoviefromDB(String movieName){

        return movies.get(movieName);
    }

    public Director getDirectorfromDB(String directorName){

        return directors.get(directorName);
    }

    public List<String> getMovieListfromDB(String directorName){
        List<String> listofMovies = new ArrayList<>();
        for(String moviename:movieDirectorPair.keySet()){
            if(movieDirectorPair.get(moviename).equals(directorName)){
                list.add(moviename);
            }
        }

        return list;
    }

    public List<String> getListofAllMoviesfromDB(){
        List<String> movieList = new ArrayList<>();
        for(String movieName:movies.keySet()){
            list.add(movieName);
        }

        return list;
    }

    public void deleteMovieList(String directorName){
//        HashSet<String> movielist = new HashSet<>();
        for(String moviename:movieDirectorPair.keySet()){
            if(movieDirectorPair.get(moviename).equals(directorName)){
                if(movies.containsKey(moviename))
                    movies.remove(moviename);
                if(directors.containsKey(directorName))
                    directors.remove(directorName);
            }
        }
    }

    public void deleteAllDirectorsMovie(){
        for(String movieName:movieDirectorPair.keySet()){
            if(movies.containsKey(movieName)){
                movies.remove(movieName);
            }
            if(directors.containsKey(movieDirectorPair.get(movieName))){
                directors.remove(movieDirectorPair.get(movieName));
            }
        }
    }


}
