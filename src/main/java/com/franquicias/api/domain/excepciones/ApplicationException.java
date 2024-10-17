package com.franquicias.api.domain.excepciones;

public class ApplicationException extends RuntimeException{
    private String msg;
    public ApplicationException(String msg){
        super(msg);
    }
}
