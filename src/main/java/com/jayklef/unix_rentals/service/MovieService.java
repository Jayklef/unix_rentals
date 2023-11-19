package com.jayklef.unix_rentals.service;

import com.jayklef.unix_rentals.dto.MovieDto;
import com.jayklef.unix_rentals.dto.MovieResponse;

import java.util.List;

public interface MovieService {
    MovieDto saveMovie(MovieDto movieDto);

    MovieResponse getAllMovies(int pageNo, int pageSize, String sortDir, String sortBy);

    List<MovieDto> findAllByGenreId(Long genreId);

    MovieDto getMovie(Long id);

    MovieDto updateMovie(Long id, MovieDto movieDto);

    void deleteMovie(Long id);
}
