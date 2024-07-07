package org.uz.entity.service;

import org.uz.entity.Database.DB;

public class AdminService {
    public static void adminService() {
        while (true) {
            System.out.println("""
                    Admin Menu:
                    1. show Rooms
                    2. book for temporary
                    3. cancel booking
                    4. active bookings
                    5. history
                    6. out of work
                    """);

            int choice = DB.scanner.nextInt();
            DB.scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> showRooms();
                case 2 -> bookForTemporary();
                case 3 -> cancelBooking();
                case 4 -> activeBookings();
                case 5 -> History();
                case 6 -> outOfWork();
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showRooms() {

    }

    private static void bookForTemporary() {

    }

    private static void cancelBooking() {

    }

    private static void activeBookings() {

    }

    private static void History() {

    }

    private static void outOfWork() {

    }
}
