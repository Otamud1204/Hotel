package org.uz.entiti.Database;

import org.uz.entiti.entitiy.Role;
import org.uz.entiti.entitiy.User;

import java.util.ArrayList;
import java.util.Scanner;

public class DB {
    public static Scanner scanner = new Scanner(System.in);
    public static Scanner strScanner = new Scanner(System.in);
    public static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        users.add(new User("admin", "admin", "123", "admin123", Role.ADMIN));
        git
    }
}
