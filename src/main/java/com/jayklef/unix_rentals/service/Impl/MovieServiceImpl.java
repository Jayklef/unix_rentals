package com.jayklef.unix_rentals.service.Impl;

import com.jayklef.unix_rentals.dto.MovieDto;
import com.jayklef.unix_rentals.entity.Movie;
import com.jayklef.unix_rentals.exception.ResourceNotFoundException;
import com.jayklef.unix_rentals.repository.MovieRepository;
import com.jayklef.unix_rentals.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

       /* MovieDto movieResponse = new MovieDto();
        movieResponse.setId(newMovie.getId());
        movieResponse.setTitle(newMovie.getTitle());
        movieResponse.setDirector(newMovie.getDirector());
        movieResponse.setReleaseYear(newMovie.getReleaseYear()); */

        return convertToMovieDto(newMovie);

    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream().map(
                movie -> convertToMovieDto(movie)
        ).collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Movie", "id", id));

        return convertToMovieDto(movie);
    }

    private MovieDto convertToMovieDto(Movie movie){
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDirector(movie.getDirector());
        movieDto.setReleaseYear(movie.getReleaseYear());

        return movieDto;
    }
}
