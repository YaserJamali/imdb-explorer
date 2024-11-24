package com.globox.ali.exceptions;


public class NoSuchGenreExistsException extends RuntimeException {
    private final String genre;

    public NoSuchGenreExistsException(String genre) {
        super(String.format("No such genre exists: %s", genre));
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}