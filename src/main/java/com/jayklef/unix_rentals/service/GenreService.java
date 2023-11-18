package com.jayklef.unix_rentals.service;

import com.jayklef.unix_rentals.dto.GenreDto;

import java.util.List;

public interface GenreService {

    GenreDto createGenre(GenreDto genreDto);

    List<GenreDto> allGenre();

    GenreDto getById(Long id);

    GenreDto updateGenre(Long id, GenreDto genreDto);

    void deleteGenre(Long id);
}
