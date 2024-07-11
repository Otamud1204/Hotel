package org.uz.entity.entitiy;

import lombok.Data;

@Data
public class Card {
    private String cardNumber;
    private int expiryYear;
    private int expiryMonth;
    private double balance;

    public Card(String cardNumber, int expiryYear, int expiryMonth, double balance) {
        this.cardNumber = cardNumber;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
        this.balance = balance;
    }
}
