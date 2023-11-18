package com.jayklef.unix_rentals.service.Impl;

import com.jayklef.unix_rentals.dto.GenreDto;
import com.jayklef.unix_rentals.entity.Genre;
import com.jayklef.unix_rentals.repository.GenreRepository;
import com.jayklef.unix_rentals.service.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    private GenreDto convertToGenreDto(Genre genre) {

        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setName(genre.getName());

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
