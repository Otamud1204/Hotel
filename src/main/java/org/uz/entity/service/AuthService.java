package org.uz.entity.service;

import org.uz.entity.Database.DB;
import org.uz.entity.entitiy.Role;
import org.uz.entity.entitiy.User;

public class AuthService {
    public AuthService() {}

    public static void signUp() {
        User user = new User();
        System.out.println("Ismingizni kiriting...");
        user.setName(DB.strScanner.nextLine());
        System.out.println("Familiyangizni kiriting...");
        user.setSurname(DB.strScanner.nextLine());
        System.out.println("Telefon raqamingizni kiriting...");
        user.setPhoneNumber(DB.strScanner.nextLine());
        System.out.println("Parolingizni kiriting...");
        user.setPassword(DB.strScanner.nextLine());
        user.setRole(Role.USER);
        DB.users.add(user);
        System.out.println("Ro'yhatdan muvaffaqiyatli o'tildi");
    }

    public static void signIn() {
        System.out.println("Ismingizni kiriting...");
        String name = DB.strScanner.nextLine();
        System.out.println("Parolingizni kiriting...");
        String password = DB.strScanner.nextLine();

        for (User user : DB.users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                if (user.getRole().equals(Role.USER)) {
                    UserService.userService(user);
                } else if (user.getRole().equals(Role.ADMIN)) {
                    AdminService.adminService();
                }
                return;
            }
        }
        System.out.println("Foydalanuvchi topilmadi");
    }
}
