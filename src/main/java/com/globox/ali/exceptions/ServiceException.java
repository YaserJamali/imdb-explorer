package com.globox.ali.exceptions;

import lombok.Getter;

@Getter
public class ServiceException extends Exception{

    private final String errorCode;

    public ServiceException(String errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ServiceException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

}