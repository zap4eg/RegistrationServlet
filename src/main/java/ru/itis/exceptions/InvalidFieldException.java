package ru.itis.exceptions;

public class InvalidFieldException extends Exception {
    public InvalidFieldException(String fieldName) {
        super(fieldName);
    }

    public InvalidFieldException() {}
}