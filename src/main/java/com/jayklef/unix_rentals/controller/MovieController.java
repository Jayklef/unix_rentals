package com.jayklef.unix_rentals.controller;

import com.jayklef.unix_rentals.dto.MovieDto;
import com.jayklef.unix_rentals.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies/")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("")
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto){
        MovieDto newMovie = movieService.saveMovie(movieDto);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDto>> movies(){
        List<MovieDto> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovioe(@PathVariable("id") Long id){
        MovieDto movie = movieService.getMovie(id);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable("id") Long id,
                                                @RequestBody MovieDto movieDto){
        MovieDto movieToUpdate = movieService.updateMovie(id, movieDto);
        return new ResponseEntity<>(movieToUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }
}
