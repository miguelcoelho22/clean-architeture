package org.example.core.exception;

public class EmailException extends Exception{

    private String code;

    public EmailException(String code, String message) {
        super(message);
        this.code = code;
    }
}
