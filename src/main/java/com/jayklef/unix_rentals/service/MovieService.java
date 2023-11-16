package com.jayklef.unix_rentals.service;

import com.jayklef.unix_rentals.dto.MovieDto;

import java.util.List;

public interface MovieService {
    MovieDto saveMovie(MovieDto movieDto);

    List<MovieDto> getAllMovies();

    MovieDto getMovie(Long id);
}
