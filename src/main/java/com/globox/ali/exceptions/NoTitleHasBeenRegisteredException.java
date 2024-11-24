package com.globox.ali.exceptions;


import lombok.Getter;

@Getter
public class NoTitleHasBeenRegisteredException extends RuntimeException {
    private final String actorName;

    public NoTitleHasBeenRegisteredException(String actorName) {
        super(String.format("No titles have been registered for the specified actor: %s", actorName));
        this.actorName = actorName;
    }

}