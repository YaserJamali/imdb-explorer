package com.globox.ali.exceptions;


public class NoTitleHasBeenRegisteredException extends RuntimeException {
    private String actorName;

    public NoTitleHasBeenRegisteredException(String actorName) {
        super(String.format("No titles have been registered for the specified actor: %s", actorName));
        this.actorName = actorName;
    }

    public String getActorName() {
        return actorName;
    }
}