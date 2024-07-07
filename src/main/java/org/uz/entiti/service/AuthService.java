package org.uz.entiti.service;

import org.uz.entiti.entitiy.Role;
import org.uz.entiti.entitiy.User;

import static org.uz.entiti.Database.DB.strScanner;
import static org.uz.entiti.Database.DB.users;

public class AuthService {
    public static void signUp() {
        User user = new User();

        System.out.println("Enter name...");
        user.setName(strScanner.nextLine());
        System.out.println("Enter surname...");
        user.setSurname(strScanner.nextLine());
        System.out.println("Enter phone number...");
        user.setPhoneNumber(strScanner.nextLine());
        System.out.println("Enter password...");
        user.setPassword(strScanner.nextLine());
        user.setRole(Role.USER);
        users.add(user);
        System.out.println("Signed successfully");
    }

    public static void signIn() {
        System.out.println("Enter name...");
        String name = strScanner.nextLine();
        System.out.println("Enter password...");
        String password = strScanner.nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name) && users.get(i).getPassword().equals(password)) {
                if (users.get(i).getRole().equals(Role.USER)) UserService.userService();
                if (users.get(i).getRole().equals(Role.ADMIN)) AdminService.adminService();
            }
        }
    }

}
