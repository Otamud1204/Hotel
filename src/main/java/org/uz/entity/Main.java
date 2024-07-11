package org.uz.entity;

import org.uz.entity.Database.DB;
import org.uz.entity.service.AuthService;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Sign Up\n2. Sign In\n3. Exit");
            int choice = DB.scanner.nextInt();
            DB.scanner.nextLine();
            switch (choice) {
                case 1:
                    AuthService.signUp();
                    break;
                case 2:
                    AuthService.signIn();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
