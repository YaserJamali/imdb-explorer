package com.globox.ali.exceptions;


import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.globox.ali.dto.ErrorResponseDto;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@ControllerAdvice
public class ExceptionsHandler {

    private static final String[] LOCALES = {"fa_IR", "en_US", "tr_TR"};
    private final Map<String, Properties> propertiesMap = new HashMap<>();

    @PostConstruct
    private void init() throws IOException {
        for (String locale : LOCALES) {
            Properties properties = new Properties();
            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("exception_" + locale + ".properties");
                 InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(inputStreamReader)) {
                properties.load(reader);
                propertiesMap.put(locale, properties);
            }
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponseDto handleException(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        String locale = Optional.ofNullable(request.getHeader("locale")).orElse("fa_IR");
        Properties properties = propertiesMap.getOrDefault(locale, propertiesMap.get("fa_IR"));

        String errorKey = getErrorKey(e);
        String message = getErrorMessage(properties, errorKey, e);
        String path = request.getRequestURI();

        return ErrorResponseDto.builder()
                .message(message)
                .timeStamp(new Date())
                .path(path)
                .build();
    }

    private String getErrorKey(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            return ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors().stream()
                    .findFirst()
                    .map(FieldError::getDefaultMessage)
                    .orElse(e.getClass().getName());
        }
        return e.getClass().getName();
    }

    private String getErrorMessage(Properties properties, String errorKey, Exception e) {
        String template = Optional.ofNullable(properties.getProperty(errorKey))
                .orElse(properties.getProperty(Exception.class.getName()));

        if (e instanceof NoTitleHasBeenRegisteredException) {
            String actorName = ((NoTitleHasBeenRegisteredException) e).getActorName();
            return String.format(template, actorName);
        } else if (e instanceof NoMovieExistsForTheesActors) {
            String actorNames = ((NoMovieExistsForTheesActors) e).getActorNames();
            return String.format(template, actorNames);
        } else if (e.getCause() instanceof UnrecognizedPropertyException) {
            String propertyName = ((UnrecognizedPropertyException) e.getCause()).getPropertyName();
            return String.format(template, propertyName);
        }

        return template;
    }
}
