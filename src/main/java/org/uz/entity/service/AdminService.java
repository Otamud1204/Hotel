package org.uz.entity.service;

import org.uz.entity.Database.DB;
import org.uz.entity.Database.OrderHistory;
import org.uz.entity.entitiy.Room;

import java.util.Date;

public class AdminService {
    public AdminService() {}

    public static void adminService() {
        while (true) {
            System.out.println("Admin Menu:\n1. Show Rooms\n2. Book Temporary\n3. Cancel Booking\n4. Active Bookings\n5. History\n6. Exit\n");
            int choice = DB.scanner.nextInt();
            DB.scanner.nextLine();
            switch (choice) {
                case 1:
                    showRooms();
                    break;
                case 2:
                    bookForTemporary();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    activeBookings();
                    break;
                case 5:
                    showHistory();
                    break;
                case 6:
                    System.out.println("Ishdan chiqildi.");
                    return;
                default:
                    System.out.println("Noto'g'ri tanlov! Iltimos, qaytadan urinib ko'ring.");
            }
        }
    }

    private static void showRooms() {
        System.out.println("Barcha xonalar:");
        for (int i = 0; i < Room.rooms.length; i++) {
            for (int j = 0; j < Room.rooms[i].length; j++) {
                System.out.println("Xona[" + i + "][" + j + "]: " + Room.rooms[i][j]);
            }
        }
    }

    private static void bookForTemporary() {
        System.out.println("Xonani vaqtinchalik bron qilish...");
        System.out.println("Qavatni kiriting (0-9):");
        int floor = DB.scanner.nextInt();
        System.out.println("Xona raqamini kiriting (0-19):");
        int roomNumber = DB.scanner.nextInt();
        Room.rooms[floor][roomNumber].setFree(false);
        Room.rooms[floor][roomNumber].setDate(new Date());
        Room.rooms[floor][roomNumber].setActive(true);
        System.out.println("Xona muvaffaqiyatli vaqtinchalik bron qilindi.");
    }

    private static void cancelBooking() {
        System.out.println("Bronni bekor qilish...");
        System.out.println("Qavatni kiriting (0-9):");
        int floor = DB.scanner.nextInt();
        System.out.println("Xona raqamini kiriting (0-19):");
        int roomNumber = DB.scanner.nextInt();
        Room.rooms[floor][roomNumber].setFree(true);
        Room.rooms[floor][roomNumber].setActive(false);
        System.out.println("Bron muvaffaqiyatli bekor qilindi.");
    }

    private static void activeBookings() {
        System.out.println("Faol bronlar:");
        for (int i = 0; i < Room.rooms.length; i++) {
            for (int j = 0; j < Room.rooms[i].length; j++) {
                if (!Room.rooms[i][j].getFree() && Room.rooms[i][j].getActive()) {
                    System.out.println("Xona[" + i + "][" + j + "]: " + Room.rooms[i][j]);
                }
            }
        }
    }

    private static void showHistory() {
        System.out.println("Bronlar tarixi:");
        for (Room room : OrderHistory.history) {
            System.out.println(room);
        }
    }
}
