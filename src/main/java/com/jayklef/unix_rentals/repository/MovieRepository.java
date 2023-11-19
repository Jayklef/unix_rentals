package com.jayklef.unix_rentals.repository;

import com.jayklef.unix_rentals.dto.MovieDto;
import com.jayklef.unix_rentals.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMoviesByGenreId(Long genreId);
}
