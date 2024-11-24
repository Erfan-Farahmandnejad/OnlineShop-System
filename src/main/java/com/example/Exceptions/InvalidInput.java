package com.example.Exceptions;

public abstract class InvalidInput extends Exception {
    public InvalidInput(String message) {
        super("InvalidInput!!__" + message);
    }
}
