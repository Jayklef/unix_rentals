package com.jayklef.unix_rentals.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GenreDto {

    private Long id;

    @NotEmpty
    @Size(min = 4, message = "Genre must have a minimum of 4 characters")
    private String name;
}
