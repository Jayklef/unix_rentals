package com.jayklef.unix_rentals.service.Impl;

import com.jayklef.unix_rentals.dto.GenreDto;
import com.jayklef.unix_rentals.entity.Genre;
import com.jayklef.unix_rentals.entity.Movie;
import com.jayklef.unix_rentals.exception.ResourceNotFoundException;
import com.jayklef.unix_rentals.repository.GenreRepository;
import com.jayklef.unix_rentals.service.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private ModelMapper mapper;

    public GenreServiceImpl(GenreRepository genreRepository,
                            ModelMapper mapper) {
        this.genreRepository = genreRepository;
        this.mapper = mapper;
    }


    @Override
    public GenreDto createGenre(GenreDto genreDto){

        Genre genre = new Genre();
        genre.setId(genreDto.getId());
        genre.setName(genreDto.getName());

        Genre newGenre = genreRepository.save(genre);
        return convertToGenreDto(newGenre);

    }

    @Override
    public List<GenreDto> allGenre() {
        return genreRepository.findAll()
                .stream()
                .map(genre -> convertToGenreDto(genre))
                .collect(Collectors.toList());
    }

    @Override
    public GenreDto getById(Long id) {

        Genre genre = genreRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Genre", "id", id));


        return convertToGenreDto(genre);
    }

    @Override
    public GenreDto updateGenre(Long id, GenreDto genreDto) {

        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre", "id", id));

        genre.setName(genreDto.getName());

        Genre updatedGenre = genreRepository.save(genre);
        return convertToGenreDto(updatedGenre);
    }

    @Override
    public void deleteGenre(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Genre", "id", id));
        genreRepository.delete(genre);
    }

    private GenreDto convertToGenreDto(Genre genre) {

    /*    GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setName(genre.getName());  */

        GenreDto genreDto = mapper.map(genre, GenreDto.class);

        return genreDto;
    }

    private Genre mapToEntity(GenreDto genreDto){
      /*  Genre genre = new Genre();
        genre.setId(genreDto.getId());
        genre.setName(genreDto.getName()); */

        Genre genre = mapper.map(genreDto, Genre.class);

        return genre;
    }
}
