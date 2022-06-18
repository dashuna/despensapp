package com.dasha.despensapp.exceptions;

public class UserNotFoundException  extends Exception {
    public UserNotFoundException(String username) {
        super("Usuario "+ username + " no encontrado");
    }
}