package it.euris.javaacademy.centro_sportivo_CA.exception;

public class IdMustBeNullException extends RuntimeException{
    public IdMustBeNullException(){super("Id must be null. You sent a dto whit an id already present");}
    public IdMustBeNullException(String message){super(message);}
}
