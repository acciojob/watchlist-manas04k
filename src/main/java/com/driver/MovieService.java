package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovietoDB(Movie movie){
        movieRepository.addMovieinDB(movie);
    }

    public void addDirectortoDB(Director director){
        movieRepository.addDirectorinDB(director);
    }

    public void addPair(String movieName, String directorName){
        movieRepository.addMovieDirectorPair(movieName, directorName);
    }

    public Movie getMovie(String movieName){
        return movieRepository.getMoviefromDB(movieName);
    }

    public Director getDirector(String directorName){
        return movieRepository.getDirectorfromDB(directorName);
    }

    public List<String> getMovieList(String directorName){
        return movieRepository.getMovieListfromDB(directorName);
    }

    public List<String> getAllMovies(){
        return movieRepository.getListofAllMoviesfromDB();
    }

    public void deleteList(String directorName){
        movieRepository.deleteMovieList(directorName);
    }

    public void deleteAll(){movieRepository.deleteAllDirectorsMovie();}
}
