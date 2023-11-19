package com.jayklef.unix_rentals.controller;

import com.jayklef.unix_rentals.dto.MovieDto;
import com.jayklef.unix_rentals.dto.MovieResponse;
import com.jayklef.unix_rentals.service.MovieService;
import com.jayklef.unix_rentals.util.ParamConstants;
import jakarta.validation.Valid;
import org.hibernate.id.factory.IdentifierGeneratorFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
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

    @GetMapping("/all")
    public MovieResponse getAllMovies(
            @RequestParam(value = "pageNo", defaultValue = ParamConstants.DEFAULT_PAGE_NO, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = ParamConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = ParamConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = ParamConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir){
        MovieResponse movies = movieService.getAllMovies(pageNo, pageSize, sortBy, sortDir);
        return movies;

    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable("id") Long id){
        MovieDto movie = movieService.getMovie(id);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable("id") Long id,
                                                @Valid @RequestBody MovieDto movieDto){
        MovieDto movieToUpdate = movieService.updateMovie(id, movieDto);
        return new ResponseEntity<>(movieToUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }
}
