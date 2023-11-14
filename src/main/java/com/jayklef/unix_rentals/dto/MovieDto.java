package com.jayklef.unix_rentals.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class MovieDto {

    private Long id;

    @NotEmpty
    @Size(min = 5, message = "Movie titile should have a minimum of 5 characters")
    private String title;

    @NotEmpty
    @Size(min = 6, message = "Movie director should have a minimum of 6 characters")
    private String director;

    private Date releaseYear;
}
