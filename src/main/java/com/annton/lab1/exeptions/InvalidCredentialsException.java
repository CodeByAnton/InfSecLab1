package com.annton.lab1.exeptions;

public class InvalidCredentialsException extends  RuntimeException{
    public InvalidCredentialsException(String message){
        super(message);
    }
}
