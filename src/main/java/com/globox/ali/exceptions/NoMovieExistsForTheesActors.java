package com.globox.ali.exceptions;

public class NoMovieExistsForTheesActors extends RuntimeException {
    private final String firstActorNAme;
    private final String secondActorName;

    public NoMovieExistsForTheesActors(String firstActorNAme, String secondActorName) {
        super(String.format("No titles have been registered for the both specified name : %s and name: %s", firstActorNAme, secondActorName));
        this.firstActorNAme = firstActorNAme;
        this.secondActorName = secondActorName;
    }

    public String getActorNames() {
        return firstActorNAme + " " + secondActorName;
    }
}
