package org.uz.entity.entitiy;

import lombok.Data;

import java.util.Date;

@Data
public class Room {
    public static Room[][] rooms = new Room[10][20]; // 10 qavat, 20 xona har bir qavatda
    private boolean isFree;
    private boolean isActive;
    private String bookedBy;
    private Date dateFrom;
    private Date dateTo;
    private double price;

    public Room(boolean isFree, boolean isActive, String bookedBy, Date dateFrom, Date dateTo, double price) {
        this.isFree = isFree;
        this.isActive = isActive;
        this.bookedBy = bookedBy;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
    }

    static {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                rooms[i][j] = new Room(true, false, null, null, null, 100.0); // Har bir xona narxi 100.0 deb belgilangan
            }
        }
    }
}
