package com.jayklef.unix_rentals.service.Impl;

import com.jayklef.unix_rentals.dto.MovieDto;
import com.jayklef.unix_rentals.entity.Movie;
import com.jayklef.unix_rentals.repository.MovieRepository;
import com.jayklef.unix_rentals.service.MovieService;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDto saveMovie(MovieDto movieDto) {

        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setTitle(movieDto.getTitle());
        movie.setDirector(movieDto.getDirector());
        movie.setReleaseYear(movieDto.getReleaseYear());

        Movie newMovie = movieRepository.save(movie);

        MovieDto movieResponse = new MovieDto();
        movieResponse.setId(newMovie.getId());
        movieResponse.setTitle(newMovie.getTitle());
        movieResponse.setDirector(newMovie.getDirector());
        movieResponse.setReleaseYear(newMovie.getReleaseYear());

        return movieResponse;

    }
}
