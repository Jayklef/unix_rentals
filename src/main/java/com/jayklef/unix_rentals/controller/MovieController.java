package com.jayklef.unix_rentals.controller;

import com.jayklef.unix_rentals.dto.MovieDto;
import com.jayklef.unix_rentals.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies/")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/")
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto){
        MovieDto newMovie = movieService.saveMovie(movieDto);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }
}
