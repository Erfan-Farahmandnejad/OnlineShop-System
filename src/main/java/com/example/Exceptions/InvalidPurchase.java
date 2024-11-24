package com.example.Exceptions;

public abstract class InvalidPurchase extends Exception {
    public InvalidPurchase(String message) {
        super("InvalidPurchase!!__" + message);
    }
}
