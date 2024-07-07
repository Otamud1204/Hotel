package org.uz.entiti.service;

import org.uz.entiti.Database.DB;

public class UserService {
    public static void userService() {
        while (true) {

            System.out.println("""
                    0 -> exit
                    1 -> my booking
                    2 -> active rooms
                    3 -> booking
                    4 -> cancel
                    5 -> balance
                    """);
            switch (DB.scanner.nextInt()) {
                case 0 -> {
                    System.out.println("bye bye");
                    return;
                }
                case 1 -> {
                    myBookings();
                }
                case 2 -> {
                    activeRooms();
                }
                case 3 -> {
                    booking();
                }
                case 4 -> {
                    cancel();
                }
                case 5 -> {
                    balance();
                }
            }
        }
    }

    private static void myBookings() {

    }

    private static void activeRooms() {

    }

    private static void booking() {

    }

    private static void cancel() {

    }

    private static void balance() {

    }
}
