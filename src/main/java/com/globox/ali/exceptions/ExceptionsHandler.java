package com.yaser.edu.handler;


import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.yaser.edu.dto.ExceptionDto;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@ControllerAdvice
public class ExceptionsHandler {

    private final static String[] LOCALES = {"fa_IR", "en_US"};
    Map<String, Properties> propertiesMap = new HashMap<>();

    @PostConstruct
    private void init() throws IOException {
        for (String locale : LOCALES) {
            Properties properties = new Properties();
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("exception_" + locale + ".properties");
            assert inputStream != null;
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            properties.load(reader);
            propertiesMap.put(locale, properties);
        }

    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handleException(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        String locale = request.getHeader("locale");
        Properties properties = this.propertiesMap.get(locale);
        if (properties == null) {
            properties = propertiesMap.get("fa_IR");
        }

        String errorKey = e.getClass().getName();
        if (e instanceof MethodArgumentNotValidException) {
            for (FieldError fieldError : ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors()) {
                errorKey = fieldError.getDefaultMessage();
            }

        }
        Object translate = properties.get(errorKey);
        if (translate == null) {
            translate = propertiesMap.get(Exception.class.getName());
        }
        if (null != e.getCause() && e.getCause() instanceof UnrecognizedPropertyException) {
            String propertyName1 = ((UnrecognizedPropertyException) e.getCause()).getPropertyName();
            translate = String.format(String.valueOf(translate), propertyName1);
        }


        return ExceptionDto.builder()
                .message(String.valueOf(translate))
                .timeStamp(new Date())
                .build();

    }

}
