package org.uz.entity.service;

import org.uz.entity.Database.DB;
import org.uz.entity.entitiy.Room;
import org.uz.entity.entitiy.User;

import java.util.Date;

public class UserService {
    public UserService() {}

    public static void userService() {
        while (true) {
            System.out.println("0 -> Exit\n1 -> My Bookings\n2 -> Active Rooms\n3 -> Make a Booking\n4 -> Cancel Booking\n5 -> Check Balance\n");
            int choice = DB.scanner.nextInt();
            DB.scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Xayr");
                    return;
                case 1:
                    myBookings();
                    break;
                case 2:
                    activeRooms();
                    break;
                case 3:
                    booking();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    checkBalance();
                    break;
                default:
                    System.out.println("Noto'g'ri tanlov! Iltimos, qaytadan urinib ko'ring.");
            }
        }
    }

    private static void myBookings() {
        System.out.println("Sizning bronlaringiz:");
        User currentUser = getCurrentUser();
        if (currentUser != null) {
            for (int i = 0; i < Room.rooms.length; i++) {
                for (int j = 0; j < Room.rooms[i].length; j++) {
                    Room room = Room.rooms[i][j];
                    // getBookedBy metodini ishlatishni o'zgartirdim
                    if (room.getBookedBy() != null && room.getBookedBy().equals(currentUser.getName())) {
                        System.out.println("Xona[" + i + "][" + j + "]: " + room);
                    }
                }
            }
        } else {
            System.out.println("Foydalanuvchi topilmadi.");
        }
    }

    private static void activeRooms() {
        System.out.println("Barcha faol xonalar:");
        for (int i = 0; i < Room.rooms.length; i++) {
            for (int j = 0; j < Room.rooms[i].length; j++) {
                if (Room.rooms[i][j].getActive() && Room.rooms[i][j].getFree()) {
                    System.out.println("Xona[" + i + "][" + j + "]: " + Room.rooms[i][j]);
                }
            }
        }
    }

    private static void booking() {
        System.out.println("Xonani bron qilish...");
        System.out.println("Qavatni kiriting (0-9):");
        int floor = DB.scanner.nextInt();
        System.out.println("Xona raqamini kiriting (0-19):");
        int roomNumber = DB.scanner.nextInt();
        User currentUser = getCurrentUser();
        if (currentUser != null) {
            Room.rooms[floor][roomNumber].setFree(false);
            Room.rooms[floor][roomNumber].setDate(new Date());
            Room.rooms[floor][roomNumber].setActive(true);
            Room.rooms[floor][roomNumber].setBookedBy(currentUser.getName()); // Foydalanuvchi tomonidan bron qilingan xona
            System.out.println("Xona muvaffaqiyatli bron qilindi.");
        } else {
            System.out.println("Foydalanuvchi topilmadi.");
        }
    }

    private static void cancelBooking() {
        System.out.println("Bronni bekor qilish...");
        System.out.println("Qavatni kiriting (0-9):");
        int floor = DB.scanner.nextInt();
        System.out.println("Xona raqamini kiriting (0-19):");
        int roomNumber = DB.scanner.nextInt();
        Room.rooms[floor][roomNumber].setFree(true);
        Room.rooms[floor][roomNumber].setActive(false);
        Room.rooms[floor][roomNumber].setBookedBy(null); // Bron bekor qilindi
        System.out.println("Bron muvaffaqiyatli bekor qilindi.");
    }

    private static void checkBalance() {
        System.out.println("Balansingizni tekshirish...");
        User currentUser = getCurrentUser();
        if (currentUser != null) {
            System.out.println("Balansingiz: $" + currentUser.getBalance());
        } else {
            System.out.println("Foydalanuvchi topilmadi.");
        }
    }

    private static User getCurrentUser() {
        // Foydalanuvchi tekshirish logikasini qo'shing
        return null; // Demo uchun null qaytarildi
    }
}
