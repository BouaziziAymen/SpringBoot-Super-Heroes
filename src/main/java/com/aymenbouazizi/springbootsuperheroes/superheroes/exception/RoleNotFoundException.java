package com.aymenbouazizi.springbootsuperheroes.superheroes.exception;

public class RoleNotFoundException extends Exception{
    public RoleNotFoundException(String message){
        super(message);
    }
}
