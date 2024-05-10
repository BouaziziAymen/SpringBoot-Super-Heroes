package com.aymenbouazizi.springbootsuperheroes.superheroes.exception;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
