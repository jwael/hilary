package com.web.atrio.test.exception;

/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

public enum ErrorCodes {


    Person_NOT_FOUND(3000),
    Person_NOT_VALID(3001);


    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
