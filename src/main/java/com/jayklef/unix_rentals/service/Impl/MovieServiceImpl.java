package com.jayklef.unix_rentals.service.Impl;

import com.jayklef.unix_rentals.dto.MovieDto;
import com.jayklef.unix_rentals.dto.MovieResponse;
import com.jayklef.unix_rentals.entity.Movie;
import com.jayklef.unix_rentals.exception.ResourceNotFoundException;
import com.jayklef.unix_rentals.repository.MovieRepository;
import com.jayklef.unix_rentals.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        movie.setGenre(movieDto.getGenre());

        Movie newMovie = movieRepository.save(movie);

       /* MovieDto movieResponse = new MovieDto();
        movieResponse.setId(newMovie.getId());
        movieResponse.setTitle(newMovie.getTitle());
        movieResponse.setDirector(newMovie.getDirector());
        movieResponse.setReleaseYear(newMovie.getReleaseYear()); */

        return convertToMovieDto(newMovie);

    }

    @Override
    public MovieResponse getAllMovies(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.DEFAULT_DIRECTION.name()) ? Sort.by(sortBy).ascending()
                        : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Movie> movies = movieRepository.findAll(pageable);

        // get content from page object

        List<Movie> movieList = movies.getContent();
        List<MovieDto> content = movieList
                .stream()
                .map(movie -> convertToMovieDto(movie))
                .collect(Collectors.toList());

        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setContent(content);
        movieResponse.setPageNo(movies.getNumber());
        movieResponse.setPageSize(movies.getSize());
        movieResponse.setTotalElements(movies.getTotalElements());
        movieResponse.setTotalPages(movies.getTotalPages());
        movieResponse.setLast(movies.isLast());


        return movieResponse;
    }

    @Override
    public MovieDto getMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Movie", "id", id));

        return convertToMovieDto(movie);
    }

    @Override
    public MovieDto updateMovie(Long id, MovieDto movieDto) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
        movie.setTitle(movieDto.getTitle());
        movie.setDirector(movieDto.getDirector());
        movie.setReleaseYear(movieDto.getReleaseYear());

        Movie updatedMovie = movieRepository.save(movie);

        return convertToMovieDto(updatedMovie);
    }

    private MovieDto convertToMovieDto(Movie movie){
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDirector(movie.getDirector());
        movieDto.setReleaseYear(movie.getReleaseYear());

        return movieDto;
    }

    @Override
    public void deleteMovie(Long id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));

        movieRepository.delete(movie);
    }
}
