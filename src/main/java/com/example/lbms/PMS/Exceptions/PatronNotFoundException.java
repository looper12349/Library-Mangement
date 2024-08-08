package com.example.lbms.PMS.Exceptions;

public class PatronNotFoundException extends RuntimeException{
    public PatronNotFoundException(String message){
        super(message);
    }
}