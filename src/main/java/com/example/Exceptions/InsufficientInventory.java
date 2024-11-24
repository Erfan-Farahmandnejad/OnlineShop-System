package com.example.Exceptions;

public class InsufficientInventory extends InvalidPurchase {
    public InsufficientInventory(String message) {
        super(message);
    }

    public InsufficientInventory() {
        super("InsufficientInventory!!");
    }
}
