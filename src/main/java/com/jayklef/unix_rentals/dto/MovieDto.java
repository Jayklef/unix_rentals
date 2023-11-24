package com.jayklef.unix_rentals.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jayklef.unix_rentals.entity.Genre;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Year;
import java.util.Date;
import java.util.List;

@Data
public class MovieDto {

    private Long id;

    @NotEmpty
    @Size(min = 5, message = "Movie title should have a minimum of 5 characters")
    private String title;

    @NotEmpty
    @Size(min = 6, message = "Movie director should have a minimum of 6 characters")
    private String director;

    @JsonFormat(pattern = "YYYY")
    private Date releaseYear;

    private Long genreId;

}
