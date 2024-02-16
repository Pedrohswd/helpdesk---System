package com.phdesk.helpdesk.services.exceptions;

public class ObjectnotFoundException extends RuntimeException{
    public ObjectnotFoundException(){
        super();
    }

    public ObjectnotFoundException(String message) {
        super(message);
    }
}
