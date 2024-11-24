package com.example.Exceptions;

public class InvalidPassword extends InvalidInput {
    public InvalidPassword(String message) {
        super(message);
    }
    public InvalidPassword() {
        super("InvalidPassword");
    }
}
