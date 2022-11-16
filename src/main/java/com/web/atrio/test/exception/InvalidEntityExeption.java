package com.web.atrio.test.exception;

import lombok.Getter;

import java.util.List;

/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

public class InvalidEntityExeption extends RuntimeException{

    @Getter
    private ErrorCodes errorCode;
    @Getter
    private List<String> errors;

    public InvalidEntityExeption(String message) {
        super(message);
    }

    public InvalidEntityExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityExeption(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidEntityExeption(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidEntityExeption(String message, ErrorCodes errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }

}
