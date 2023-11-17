package com.jayklef.unix_rentals.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetailsDto {
    private Integer status;
    private String message;
    private String path;
    private Date timestamp;
}
