package org.example.core.exception;

public class InternalServerErrorException extends Exception{

    private String code;

    public InternalServerErrorException(String code, String message) {
        super(message);
        this.code = code;
    }
}
