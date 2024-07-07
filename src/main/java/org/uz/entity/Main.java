package org.uz.entity;

import org.uz.entity.Database.DB;
import org.uz.entity.entitiy.Role;
import org.uz.entity.entitiy.User;
import org.uz.entity.service.AuthService;

import static org.uz.entity.Database.DB.users;

public class Main {
    public static void main(String[] args) {
        users.add(new User("admin", "admin", "123", "admin123", Role.ADMIN));
        while (true) {
            System.out.println("""
                    0-exit
                    1-Sign  Up
                    2-Sign In
                    """);
            switch (DB.scanner.nextInt()) {
                case 0 -> {
                    System.out.println("bye bye");
                    return;
                }
                case 1 -> AuthService.signUp();
                case 2 -> AuthService.signIn();

            }
        }
    }
}
