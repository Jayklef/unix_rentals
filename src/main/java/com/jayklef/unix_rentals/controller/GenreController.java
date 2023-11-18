package com.jayklef.unix_rentals.controller;

import com.jayklef.unix_rentals.dto.GenreDto;
import com.jayklef.unix_rentals.service.GenreService;
import com.jayklef.unix_rentals.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity<GenreDto> createGenre(@RequestBody GenreDto genreDto){
        GenreDto newGenre = genreService.createGenre(genreDto);
        return new ResponseEntity<>(newGenre, HttpStatus.CREATED);
    }
}
