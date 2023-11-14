package com.jayklef.unix_rentals.repository;

import com.jayklef.unix_rentals.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
