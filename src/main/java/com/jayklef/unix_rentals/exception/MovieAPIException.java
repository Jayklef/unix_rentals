package com.jayklef.unix_rentals.exception;

import org.springframework.http.HttpStatus;

public class MovieAPIException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public MovieAPIException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public MovieAPIException(String message, HttpStatus status, String message1){
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
