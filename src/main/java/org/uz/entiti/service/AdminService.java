package org.uz.entiti.service;

import org.uz.entiti.Database.DB;

public class AdminService {
    public static void adminService() {
        while (true) {
            System.out.println("""
                    Admin Menu:
                    1. Show Rooms
                    2. Add Room
                    3. Remove Room
                    4. Show Bookings
                    5. Remove Booking
                    6. Show Users
                    7. Remove User
                    8. Exit to Main Menu
                    """);

            int choice = DB.scanner.nextInt();
            DB.scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    showRooms();
                    break;
                case 2:
                    addRoom();
                    break;
                case 3:
                    removeRoom();
                    break;
                case 4:
                    showBookings();
                    break;
                case 5:
                    removeBooking();
                    break;
                case 6:
                    showUsers();
                    break;
                case 7:
                    removeUser();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
    }

    private static void showRooms() {

    }

    private static void addRoom() {

    }

    private static void removeRoom() {

    }

    private static void showBookings() {

    }

    private static void removeBooking() {

    }

    private static void showUsers() {

    }

    private static void removeUser() {

    }
}
