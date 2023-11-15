package com.jayklef.unix_rentals.service;

import com.jayklef.unix_rentals.dto.MovieDto;

public interface MovieService {
    MovieDto saveMovie(MovieDto movieDto);
}
