package com.globox.ali.exceptions;


import lombok.Getter;

@Getter
public class NoSuchGenreExistsException extends RuntimeException {
    private final String genre;

    public NoSuchGenreExistsException(String genre) {
        super(String.format("No such genre exists: %s", genre));
        this.genre = genre;
    }

}