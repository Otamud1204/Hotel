package org.uz.entity.Database;

import java.util.ArrayList;
import java.util.Scanner;
import org.uz.entity.entitiy.Role;
import org.uz.entity.entitiy.User;

public class DB {
    public static Scanner scanner = new Scanner(System.in);
    public static Scanner strScanner = new Scanner(System.in);
    public static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User("adminbek", "admin", "1234", "admin1234", Role.ADMIN));
    }
}
