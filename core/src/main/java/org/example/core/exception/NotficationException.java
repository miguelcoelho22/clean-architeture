package org.example.core.exception;

public class NotficationException extends Exception{

    private String code;

    public NotficationException(String code, String message) {
        super(message);
        this.code = code;
    }
}
