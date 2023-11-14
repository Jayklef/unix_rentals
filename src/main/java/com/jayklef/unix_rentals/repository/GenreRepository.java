package com.jayklef.unix_rentals.repository;

import com.jayklef.unix_rentals.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
