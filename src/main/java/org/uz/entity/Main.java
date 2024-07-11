package org.uz.entity;

import org.uz.entity.Database.DB;
import org.uz.entity.service.AuthService;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("0 -> Exit\n1 -> Sign Up\n2 -> Sign In");
            int choice = DB.scanner.nextInt();
            DB.scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Xayr");
                    return;
                case 1:
                    AuthService.signUp();
                    break;
                case 2:
                    AuthService.signIn();
                    break;
                default:
                    System.out.println("Noto'g'ri tanlov! Iltimos, qaytadan urinib ko'ring.");


            }
        }
    }
}
