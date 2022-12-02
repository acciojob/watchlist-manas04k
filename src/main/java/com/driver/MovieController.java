package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody(required = true) Movie movie){
        movieService.addMovietoDB(movie);
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody(required = true) Director director){
        movieService.addDirectortoDB(director);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        movieService.addPair(movieName, directorName);
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }

    @GetMapping("/movies/get-movie-by-name/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName") String movieName){
        return new ResponseEntity(movieService.getMovie(movieName), HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{directorName}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("directorName") String directorName){
        return new ResponseEntity(movieService.getDirector(directorName), HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-movies-by-director-name/{directorName}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("directorName") String directorName){
        return new ResponseEntity(movieService.getMovieList(directorName), HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){

        return new ResponseEntity(movieService.getAllMovies(), HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("directorName") String directorName){
        movieService.deleteList(directorName);
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAll();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
