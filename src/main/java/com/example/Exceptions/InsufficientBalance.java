package com.example.Exceptions;

public class InsufficientBalance extends InvalidPurchase {
    public InsufficientBalance(String message) {
        super(message);
    }

    public InsufficientBalance() {
        super("InsufficientBalance!!");
    }
}
