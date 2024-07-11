package org.uz.entity.service;

import org.uz.entity.Database.DB;
import org.uz.entity.Database.OrderHistory;
import org.uz.entity.entitiy.Room;
import org.uz.entity.entitiy.User;

import java.util.Date;

public class UserService {
    public UserService() {}

    public static void userService(User currentUser) {
        while (true) {
            System.out.println("0 -> Exit\n1 -> Show Rooms\n2 -> Book a Room\n3 -> Booking\n4 -> Cancel Bookings\n5 -> Balance\n6 -> Add Card");            int choice = DB.scanner.nextInt();
            DB.scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Xayr");
                    return;
                case 1:
                    myBookings(currentUser);
                    break;
                case 2:
                    activeRooms();
                    break;
                case 3:
                    makeBooking(currentUser);
                    break;
                case 4:
                    cancelBooking(currentUser);
                    break;
                case 5:
                    checkBalance(currentUser);
                    break;
                case 6:
                    addCard(currentUser);
                    break;
                default:
                    System.out.println("Noto'g'ri tanlov! Iltimos, qaytadan urinib ko'ring.");
            }
        }
    }

    private static void myBookings(User currentUser) {
        System.out.println(currentUser.getName() + "ning bron qilgan xonalari:");
        for (Room room : OrderHistory.history) {
            if (room.getBookedBy() != null && room.getBookedBy().equals(currentUser.getName())) {
                System.out.println(room);
            }
        }
    }

    private static void activeRooms() {
        System.out.println("Barcha aktiv xonalar:");
        for (int floor = 0; floor < Room.rooms.length; floor++) {
            for (int roomNumber = 0; roomNumber < Room.rooms[floor].length; roomNumber++) {
                Room room = Room.rooms[floor][roomNumber];
                if (!room.isFree()) {
                    System.out.println("Qavat: " + floor + ", Xona raqami: " + roomNumber + ", Xona: " + room);
                }
            }
        }
    }

    private static void makeBooking(User currentUser) {
        System.out.println("Bron qilish uchun qavatni kiriting (0-9):");
        int floor = DB.scanner.nextInt();
        System.out.println("Xona raqamini kiriting (0-19):");
        int roomNumber = DB.scanner.nextInt();
        Room room = Room.rooms[floor][roomNumber];

        if (room.isFree()) {
            System.out.println("Bron qilish uchun narx: " + room.getPrice());
            if (currentUser.chargeBalance(room.getPrice())) {
                room.setFree(false);
                room.setActive(true);
                room.setBookedBy(currentUser.getName());
                room.setDateFrom(new Date());
                OrderHistory.history.add(room);
                System.out.println("Xona muvaffaqiyatli bron qilindi.");
            } else {
                System.out.println("Balans yetarli emas.");
            }
        } else {
            System.out.println("Xona band.");
        }
    }

    private static void cancelBooking(User currentUser) {
        System.out.println("Bekor qilish uchun qavatni kiriting (0-9):");
        int floor = DB.scanner.nextInt();
        System.out.println("Xona raqamini kiriting (0-19):");
        int roomNumber = DB.scanner.nextInt();
        Room room = Room.rooms[floor][roomNumber];

        if (!room.isFree() && room.getBookedBy().equals(currentUser.getName())) {
            room.setFree(true);
            room.setActive(false);
            room.setBookedBy(null);
            room.setDateFrom(null);
            OrderHistory.history.remove(room);
            System.out.println("Xona muvaffaqiyatli bekor qilindi.");
        } else {
            System.out.println("Siz bu xonani bron qilmagansiz yoki xona band emas.");
        }
    }

    private static void checkBalance(User currentUser) {
        System.out.println("Sizning balansingiz: " + currentUser.getBalance());
    }

    private static void addCard(User currentUser) {
        System.out.println("Karta raqamini kiriting:");
        String cardNumber = DB.strScanner.nextLine();
        System.out.println("Yilni kiriting:");
        int year = DB.scanner.nextInt();
        System.out.println("Oyni kiriting:");
        int month = DB.scanner.nextInt();
        System.out.println("Balans miqdorini kiriting:");
        double amount = DB.scanner.nextDouble();
        currentUser.addBalance(amount);
        System.out.println("Karta muvaffaqiyatli qo'shildi va balans yangilandi.");
    }
}
