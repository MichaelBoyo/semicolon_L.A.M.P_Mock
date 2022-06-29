package com.example.semicolonlamp;

public class SemicolonException extends RuntimeException{
    public SemicolonException(String message) {
        super(message);
    }
    public SemicolonException(Throwable cause){
        super(cause);
    }
    public SemicolonException(String message, Throwable cause){
        super(message,cause);
    }
    public SemicolonException(){}
}
