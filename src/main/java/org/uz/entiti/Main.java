package org.uz.entiti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.uz.entiti.Database.DB;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    0-exit
                    1-Sign  Up
                    2-Sign In             
                    """);
            switch (DB.scanner.nextInt()) {
                case 0 -> {
                    System.out.println("bye bye");
                    return;
                }
                case 1 -> {

                }
                case 2 -> {

                }

            }
        }
    }
}
