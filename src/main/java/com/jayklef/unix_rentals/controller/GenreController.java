package com.jayklef.unix_rentals.controller;

import com.jayklef.unix_rentals.dto.GenreDto;
import com.jayklef.unix_rentals.service.GenreService;
import com.jayklef.unix_rentals.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/")
    public ResponseEntity<GenreDto> createGenre(@RequestBody GenreDto genreDto){
        GenreDto newGenre = genreService.createGenre(genreDto);
        return new ResponseEntity<>(newGenre, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GenreDto>> allGenre(){
        List<GenreDto> allGenre = genreService.allGenre();
        return ResponseEntity.ok(allGenre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDto> getGenre(@PathVariable("id") Long id){
        GenreDto genreDto = genreService.getById(id);
        return new ResponseEntity<>(genreDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDto> updateGenre(@PathVariable("id") Long id,
                                                @RequestBody GenreDto genreDto){
        GenreDto updatedGenre = genreService.updateGenre(id, genreDto);
        return ResponseEntity.ok(updatedGenre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable("id") Long id){
        genreService.deleteGenre(id);
        return ResponseEntity.ok("Genre deleted successfully");
    }
}
