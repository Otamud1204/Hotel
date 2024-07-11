package org.uz.entity.service;

import org.uz.entity.Database.DB;
import org.uz.entity.Database.OrderHistory;
import org.uz.entity.entitiy.Room;
import org.uz.entity.entitiy.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AdminService {


    public AdminService() {}

    public static void adminService() {
        while (true) {
            System.out.println("0 -> Exit\n1 -> Show Rooms\n2 -> Book a Room\n3 -> Cancel Booking\n4 -> Active Bookings\n5 -> Room History\n6 -> Check Balance\n7 -> Add Card");            int choice = DB.scanner.nextInt();
            DB.scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Chiqish...");
                    return;
                case 1:
                    showRooms();
                    break;
                case 2:
                    bookForTips();
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
                    showUsers();
                    break;
                case 7:
                    deposit();
                    break;
                default:
                    System.out.println("Noto'g'ri tanlov! Iltimos, qayta urinib ko'ring.");
            }
        }
    }

    private static void showRooms() {
        System.out.println("Qavatni kiriting (0-9):");
        int floor = DB.scanner.nextInt();

        System.out.println("Qavatdagi xonalar:");
        for (int i = 0; i < Room.rooms[floor].length; i++) {
            Room room = Room.rooms[floor][i];
            System.out.println("Xona[" + floor + "][" + i + "]: " + (room.isFree() ? "Bo'sh" : "Band"));
        }
    }

    private static void bookForTips() {
        Random random = new Random();
        System.out.println("Ismingizni kiriting:");
        String firstName = DB.strScanner.nextLine();
        System.out.println("Familiyangizni kiriting:");
        String lastName = DB.strScanner.nextLine();
        System.out.println("Qaysi sanadan (yyyy-MM-dd):");
        String fromDate = DB.strScanner.nextLine();
        System.out.println("Qaysi sanagacha (yyyy-MM-dd):");
        String toDate = DB.strScanner.nextLine();
        System.out.println("Xonani tasodifiy band qilish uchun 1 ni bosing, o'zingiz tanlash uchun 2 ni bosing:");
        int choice = DB.scanner.nextInt();

        Room room = null;
        if (choice == 1) {
            int floor = random.nextInt(10);
            int roomNumber = random.nextInt(20);
            room = Room.rooms[floor][roomNumber];
        } else if (choice == 2) {
            System.out.println("Qavat raqamini kiriting (0-9):");
            int floor = DB.scanner.nextInt();
            System.out.println("Xona raqamini kiriting (0-19):");
            int roomNumber = DB.scanner.nextInt();
            room = Room.rooms[floor][roomNumber];
        }

        if (room != null && room.isFree()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dateFrom = dateFormat.parse(fromDate);
                Date dateTo = dateFormat.parse(toDate);

                room.setFree(false);
                room.setActive(true);
                room.setBookedBy(firstName + " " + lastName);
                room.setDateFrom(dateFrom);
                room.setDateTo(dateTo);
                OrderHistory.history.add(room);
                System.out.println("Xona muvaffaqiyatli band qilindi. Sizning xonangiz: " + room);
            } catch (ParseException e) {
                System.out.println("Sana formati noto'g'ri. Iltimos, yyyy-MM-dd formatidan foydalaning.");
            }
        } else {
            System.out.println("Xona band.");
        }
    }

    private static void cancelBooking() {
        System.out.println("Buyurtmani bekor qilish...");
        System.out.println("Qavat raqamini kiriting (0-9):");
        int floor = DB.scanner.nextInt();
        System.out.println("Xona raqamini kiriting (0-19):");
        int roomNumber = DB.scanner.nextInt();
        Room room = Room.rooms[floor][roomNumber];

        if (!room.isFree()) {
            room.setFree(true);
            room.setActive(false);
            room.setBookedBy(null);
            room.setDateFrom(null);
            room.setDateTo(null);
            System.out.println("Buyurtma muvaffaqiyatli bekor qilindi.");
        } else {
            System.out.println("Xona band emas.");
        }
    }

    private static void activeBookings() {
        System.out.println("Faol buyurtmalar:");
        for (int i = 0; i < Room.rooms.length; i++) {
            for (int j = 0; j < Room.rooms[i].length; j++) {
                Room room = Room.rooms[i][j];
                if (!room.isFree()) {
                    System.out.println("Xona[" + i + "][" + j + "]: " + room);
                }
            }
        }
    }

    private static void showHistory() {
        System.out.println("Buyurtmalar tarixi:");
        for (Room room : OrderHistory.history) {
            System.out.println(room);
        }
    }

    private static void showUsers() {
        System.out.println("Barcha foydalanuvchilar:");
        for (User user : DB.users) {
            System.out.println(user);
        }
    }

    private static void deposit() {
        System.out.println("Foydalanuvchi hisobiga o'tkazish...");
        System.out.println("Foydalanuvchi nomini kiriting:");
        String username = DB.strScanner.nextLine();
        System.out.println("O'tkazish uchun miqdorni kiriting:");
        double amount = DB.scanner.nextDouble();

        for (User user : DB.users) {
            if (user.getName().equals(username)) {
                user.addBalance(amount);
                System.out.println("O'tkazish muvaffaqiyatli amalga oshirildi. Yangi balans: " + user.getBalance());
                return;
            }
        }
        System.out.println("Foydalanuvchi topilmadi.");
    }
}
