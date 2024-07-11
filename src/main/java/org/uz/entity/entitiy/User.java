package org.uz.entity.entitiy;

import lombok.Data;

@Data
public class User {
    private String name;
    private String surname;
    private String phoneNumber;
    private String password;
    private Role role;
    private double balance;

    public User(String name, String surname, String phoneNumber, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.balance = 0.0;
    }

    public User() {}

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public boolean chargeBalance(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
